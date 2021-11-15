package org.serratec.backend.controller;

import java.io.IOException;
import java.util.List;

import org.serratec.backend.dto.ProdutoDTO;
import org.serratec.backend.exception.ProdutoException;
import org.serratec.backend.model.Foto;
import org.serratec.backend.model.Produto;
import org.serratec.backend.repository.ProdutoRepository;
import org.serratec.backend.service.FotoProdutoService;
import org.serratec.backend.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private FotoProdutoService fotoProdutoService;
	
	

	@GetMapping
	@ApiOperation(value = "Listar todas as Produtos", notes = "Listagem de Produtos")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Recurso proibido"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Erro no servidor") })
	public ResponseEntity<List<ProdutoDTO>> listar() {

		List<ProdutoDTO> produtosDTO = produtoService.listar();
		return ResponseEntity.ok(produtosDTO);
	}
	

	@GetMapping("{id}")
	@ApiOperation(value = "Listar um Produto", notes = "Listagem com um Produto")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Recurso proibido"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Erro no servidor") })
	public ProdutoDTO buscar(Long id) {
		return produtoService.buscar(id);
	}

	@PostMapping
	@ApiOperation(value = "Cadastrar Produto", notes = "Cadastro de Produto")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Criado com Sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Recurso proibido"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Erro no servidor") })
	public ProdutoDTO inserir(@RequestPart Produto produto, @RequestParam MultipartFile file)
			throws IOException {
		return produtoService.inserir(produto, file);
	}

	@GetMapping("/{id}/foto")
	@ApiOperation(value = "Listar foto do  Produto", notes = "Lista  foto do  Produto")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Recurso proibido"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Erro no servidor") })
	public ResponseEntity<byte[]> buscarPorFoto(@PathVariable Long id) {
		Foto foto = fotoProdutoService.buscar(id);
		HttpHeaders headers = new HttpHeaders();
		headers.add("content-type", foto.getTipo());
		headers.add("content-length", String.valueOf(foto.getDados().length));
		return new ResponseEntity<byte[]>(foto.getDados(), headers, HttpStatus.OK);
	}
	@PutMapping("/{id}")
	@ApiOperation(value = "Editar Produto", notes = "Edição de Produto")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Recurso proibido"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Erro no servidor") })
	public ResponseEntity<ProdutoDTO> alterar(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO)
			throws ProdutoException {

		if (produtoService.editar(id, produtoDTO) != null) {
			return ResponseEntity.ok(produtoDTO);
		}
		return ResponseEntity.notFound().build();

	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Exclusão de Produto", notes = "Exclui um Produto")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Excluído com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Recurso proibido"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Erro no servidor") })
	public ResponseEntity<Void> apagar(@PathVariable Long id) {
		produtoService.apagar(id);
		return ResponseEntity.noContent().build();
	}

}
