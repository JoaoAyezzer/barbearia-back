package br.com.mobintech.barbearia.service;

import br.com.mobintech.barbearia.dto.ProdutoDTO;
import br.com.mobintech.barbearia.dto.ProdutoNewDTO;
import br.com.mobintech.barbearia.models.Fornecedor;
import br.com.mobintech.barbearia.models.Produto;
import br.com.mobintech.barbearia.repositories.ProdutoRepository;
import br.com.mobintech.barbearia.service.exceptions.ObjectNotfoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private FornecedorService fornecedorService;

    public Produto create(ProdutoNewDTO produtoNewDTO){
        return produtoRepository.save(fromDTO(produtoNewDTO));
    }

    public List<ProdutoDTO> findAll(){
        List<ProdutoDTO> produtoDTOS = produtoRepository.findAll()
                .stream()
                .map(ProdutoDTO::new)
                .collect(Collectors.toList());
        return produtoDTOS;
    }

    public ProdutoDTO findById(Long id){
        Optional<Produto> produto = produtoRepository.findById(id);
        produto.orElseThrow(
                () -> new ObjectNotfoundException(
                        "Produto com Id: " + id + ", não encontrado na base de dados"
                )
        );
        return new ProdutoDTO(produto.get());
    }
    public void update(Long id, ProdutoNewDTO produtoNewDTO){
        findById(id);
        produtoNewDTO.setId(id);
        produtoRepository.save(fromDTO(produtoNewDTO));
    }
    public void delete(Long id){
        findById(id);
        produtoRepository.deleteById(id);
    }


    public Produto fromDTO(ProdutoNewDTO produtoNewDTO){
        Date data = new Date();
        Fornecedor fornecedor = fornecedorService.findById(produtoNewDTO.getIdFornecedor());
        return new Produto(
            produtoNewDTO.getId(),
            produtoNewDTO.getDescricao(),
            produtoNewDTO.getPrecoDeCompra(),
            produtoNewDTO.getPrecoDeVenda(),
            produtoNewDTO.getCodBar(),
            produtoNewDTO.getQtdEmEstoque(),
                (produtoNewDTO.getDataCadastro() == null) ? data : produtoNewDTO.getDataCadastro(),
            produtoNewDTO.getMarca(),
            fornecedor);
    }
}
