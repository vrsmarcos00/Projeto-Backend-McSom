package com.marcossa.mcsom.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.marcossa.mcsom.domain.Categoria;
import com.marcossa.mcsom.domain.Cliente;
import com.marcossa.mcsom.domain.Comissoes;
import com.marcossa.mcsom.domain.Funcionario;
import com.marcossa.mcsom.domain.Pagamento;
import com.marcossa.mcsom.domain.PagamentoComBoleto;
import com.marcossa.mcsom.domain.PagamentoComCartao;
import com.marcossa.mcsom.domain.PagamentoEmDinheiro;
import com.marcossa.mcsom.domain.Produto;
import com.marcossa.mcsom.domain.Servico;
import com.marcossa.mcsom.domain.Vales;
import com.marcossa.mcsom.domain.enums.EstadoPagamento;
import com.marcossa.mcsom.repositories.CategoriaRepository;
import com.marcossa.mcsom.repositories.ClienteRepository;
import com.marcossa.mcsom.repositories.ComissoesRepository;
import com.marcossa.mcsom.repositories.FuncionarioRepository;
import com.marcossa.mcsom.repositories.PagamentoRepository;
import com.marcossa.mcsom.repositories.ProdutoRepository;
import com.marcossa.mcsom.repositories.ServicoRepository;
import com.marcossa.mcsom.repositories.ValeRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private ValeRepository valeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ComissoesRepository comissoesRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Categoria c1 = new Categoria(null, "Acessórios");
		Categoria c2 = new Categoria(null, "Eletrônicos");
		
		Produto p1 = new Produto(null, "Computador", 2000.00, 10);
		Produto p2 = new Produto(null, "Impressora", 750.00, 30);
		Produto p3 = new Produto(null, "Som Pionner", 550.00, 25);
		
		c1.getProdutos().addAll(Arrays.asList(p3));
		c2.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		
		p1.getCategorias().addAll(Arrays.asList(c2));
		p2.getCategorias().addAll(Arrays.asList(c2));
		p3.getCategorias().addAll(Arrays.asList(c1, c2));
		
		categoriaRepository.saveAll(Arrays.asList(c1,c2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Funcionario f1 = new Funcionario(null, "Marcos de Sá", "vrr.marcos@gmail.com", "05729552190");
		f1.getTelefones().addAll(Arrays.asList("61984880278", "61984772994"));
		
		Funcionario f2 = new Funcionario(null, "Leonardo Victor", "vrr.leo@gmail.com", "00000000001");
		f2.getTelefones().addAll(Arrays.asList("61999852515", "61985586563"));
		
		Vales v1 = new Vales(null, "Almoço", new Date(), 50.00, f2);
		
		funcionarioRepository.saveAll(Arrays.asList(f1, f2));
		valeRepository.saveAll(Arrays.asList(v1));
		
		Cliente cli1 = new Cliente(null, "cliente1@gmail.com", "José Carlos", "00100658598");
		cli1.getTelefones().addAll(Arrays.asList("6185856525", "6185788547"));
		
		Cliente cli2 = new Cliente(null, "cliente1@gmail.com", "Carlos Silva", "00100658597");
		cli2.getTelefones().addAll(Arrays.asList("6155854587"));
		
		clienteRepository.saveAll(Arrays.asList(cli1, cli2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Servico s1 = new Servico(null, "Troca de Vidro", sdf.parse("09/12/2021 15:46"), 150.00, cli1);
		Servico s2 = new Servico(null, "Troca de som", sdf.parse("01/12/2021 16:59"), 450.00, cli2);
		Servico s3 = new Servico(null,"Reparo Máquina de vidro", sdf.parse("05/12/2021 10:32"), 500.00, cli2);
		
		Comissoes com1 = new Comissoes(null, 50.00, s1, f2);
		s1.setComissao(com1);
		
		Comissoes com2 = new Comissoes(null, 150.00, s2, f1);
		s2.setComissao(com2);
		
		Comissoes com3 = new Comissoes(null, 185.00, s3, f2);
		s3.setComissao(com3);
		
		Pagamento pag1 = new PagamentoComBoleto(null, EstadoPagamento.PAGO, s1, sdf.parse("15/12/2021 10:52"), sdf.parse("10/12/2021 11:52"));
		s1.setPagamento(pag1);
		
		Pagamento pag2 = new PagamentoComCartao(null, EstadoPagamento.PAGO, s2, 6);
		s2.setPagamento(pag2);
		
		Pagamento pag3 = new PagamentoEmDinheiro(null, EstadoPagamento.PAGO, s3, sdf.parse("05/10/2021 11:43"));
		s3.setPagamento(pag3);
		
		servicoRepository.saveAll(Arrays.asList(s1, s2, s3));
		comissoesRepository.saveAll(Arrays.asList(com1, com2, com3));
		pagamentoRepository.saveAll(Arrays.asList(pag1, pag2, pag3));
				
	}

}
