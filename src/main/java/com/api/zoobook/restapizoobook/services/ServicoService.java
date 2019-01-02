package com.api.zoobook.restapizoobook.services;

import com.api.zoobook.restapizoobook.domain.Usuario;
import com.api.zoobook.restapizoobook.domain.servico.ItemPedido;
import com.api.zoobook.restapizoobook.domain.servico.PagamentoComBoleto;
import com.api.zoobook.restapizoobook.domain.servico.Servico;
import com.api.zoobook.restapizoobook.domain.enums.EstadoPagamento;
import com.api.zoobook.restapizoobook.exceptions.ObjectNotFoundException;
import com.api.zoobook.restapizoobook.repositores.ItemPedidoRepository;
import com.api.zoobook.restapizoobook.repositores.PagamentoRepository;
import com.api.zoobook.restapizoobook.repositores.ServicoRepository;
import com.api.zoobook.restapizoobook.security.UserSS;
import com.api.zoobook.restapizoobook.services.exceptions.AuthorizationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository repo;

    @Autowired
    private BoletoService boletoService;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ClienteService clienteService;


    private EmailService emailService;

    public Servico find(Integer id) {
        Optional<Servico> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Servico.class.getName()));
    }

    public Servico insert(Servico obj) {
        obj.setId(null);
        obj.setInstante(new Date());
        obj.setUsuario(clienteService.find(obj.getUsuario().getId()));
        obj.getPagamento().setStatus(EstadoPagamento.PENDENTE);
        obj.getPagamento().setServico(obj);
        if (obj.getPagamento() instanceof PagamentoComBoleto) {
            PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
            boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
        }
        obj = repo.save(obj);
        pagamentoRepository.save(obj.getPagamento());
        for (ItemPedido ip : obj.getItens()) {
            ip.setDiscount(0.0);
            ip.setProduto(produtoService.find(ip.getProduto().getId()));
            ip.setPrice(ip.getProduto().getPrice());
            ip.setPedido(obj);
        }
        itemPedidoRepository.saveAll(obj.getItens());
        emailService.sendOrderConfirmationEmail(obj);
        return obj;
    }

    public Page<Servico> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        UserSS user = UserService.authenticated();
        if (user == null) {
            throw new AuthorizationException("Acesso negado");
        }
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        Usuario usuario =  clienteService.find(user.getId());
        return repo.findByUsuario(usuario, pageRequest);
    }
}
