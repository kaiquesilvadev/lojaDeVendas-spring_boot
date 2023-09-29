package com.kaique.projetoLoja.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.kaique.projetoLoja.domain.Categoria;
import com.kaique.projetoLoja.domain.Cidade;
import com.kaique.projetoLoja.domain.Cliente;
import com.kaique.projetoLoja.domain.Endereco;
import com.kaique.projetoLoja.domain.Estado;
import com.kaique.projetoLoja.domain.ItemPedido;
import com.kaique.projetoLoja.domain.Pagamento;
import com.kaique.projetoLoja.domain.PagamentoComBoleto;
import com.kaique.projetoLoja.domain.PagamentoComCartao;
import com.kaique.projetoLoja.domain.Pedido;
import com.kaique.projetoLoja.domain.Produto;
import com.kaique.projetoLoja.enums.EstadoPagamento;
import com.kaique.projetoLoja.enums.TipoCliente;
import com.kaique.projetoLoja.repositories.CategoriaRepository;
import com.kaique.projetoLoja.repositories.CidadeRepository;
import com.kaique.projetoLoja.repositories.ClienteRepository;
import com.kaique.projetoLoja.repositories.EnderecoRepository;
import com.kaique.projetoLoja.repositories.EstadoRepository;
import com.kaique.projetoLoja.repositories.ItemPedidoRepository;
import com.kaique.projetoLoja.repositories.PagamentoRepository;
import com.kaique.projetoLoja.repositories.PedidoRepository;
import com.kaique.projetoLoja.repositories.ProdutoRepository;

@Configuration
public class Testconfig implements CommandLineRunner {

	@Autowired
	private CategoriaRepository repository;

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	@Override
	public void run(String... args) throws Exception {
		Categoria p1 = new Categoria(null, "escritorio");
		Categoria p2 = new Categoria(null, "informatica");

		Produto prod1 = new Produto(null, "computador", 2000.00);
		Produto prod2 = new Produto(null, "impressora", 800.00);
		Produto prod3 = new Produto(null, "mouse", 80.00);

		
		
		p1.getProdutos().addAll(Arrays.asList(prod1, prod2, prod3));
		p2.getProdutos().addAll(Arrays.asList(prod2));

		prod1.getCategorias().addAll(Arrays.asList(p1));
		prod2.getCategorias().addAll(Arrays.asList(p1, p2));
		prod3.getCategorias().addAll(Arrays.asList(p1));
		
		produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3 )); 
		repository.saveAll(Arrays.asList(p1, p2));
		
		Estado est1 = new Estado(null , "Minas gerais");
		Estado est2 = new Estado(null , "São Paulo");
		
		Cidade c1 = new Cidade(null , "Uberlandia" , est1);
		Cidade c2 = new Cidade(null , "São Paulo" , est2);
		Cidade c3 = new Cidade(null , "Camplinas" , est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2 , c3));
		
		estadoRepository.saveAll(Arrays.asList(est1 , est2));
		cidadeRepository.saveAll(Arrays.asList(c1 , c2 , c3));
		
		Cliente clil = new Cliente(null , "mria silva " , "maria@Gmail.com" , "3237652" , TipoCliente.PESSOA_FISICA);
		
		clil.getTelefones().addAll(Arrays.asList("9876328492" , "876438208"));
		
		Endereco e1 = new Endereco(null , "rua flores" , 300 , "Apto 4" , "jardin " ,"3847363647" , clil , c1);
		Endereco e2 = new Endereco(null , "avenida matos" , 150 , "sala 34" , "centro " ,"3847363647" , clil , c2);
		
		clil.getEnderecos().addAll(Arrays.asList(e1 , e2));
		
		clienteRepository.save(clil);
		enderecoRepository.saveAll(Arrays.asList(e1 , e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		Pedido ped1 = new Pedido(null , sdf.parse("30/09/2017 10:12") , clil , e1);
		Pedido ped2 = new Pedido(null , sdf.parse("10/09/2017 13:50") , clil , e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		pedidoRepository.saveAll(Arrays.asList(ped1 , ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1 , pagto2));
		
		ItemPedido ip1 = new ItemPedido(prod1, ped1, 0.00, 1 , 2000.00);
		ItemPedido ip2 = new ItemPedido(prod3, ped1, 0.00, 2 , 80.00);
		ItemPedido ip3 = new ItemPedido(prod2, ped2, 100.00, 1 , 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1 , ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		prod1.getItens().addAll(Arrays.asList(ip1));
		prod2.getItens().addAll(Arrays.asList(ip3));
		prod3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1 , ip2 , ip3));
		
	}

}
