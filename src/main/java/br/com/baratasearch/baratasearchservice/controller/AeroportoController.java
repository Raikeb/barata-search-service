package br.com.baratasearch.baratasearchservice.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.baratasearch.baratasearchservice.dto.AeroportoDTO;
import br.com.baratasearch.baratasearchservice.dto.AeroportoResponseDTO;
import br.com.baratasearch.baratasearchservice.entity.Aeroporto;
import br.com.baratasearch.baratasearchservice.exception.StandardError;
import br.com.baratasearch.baratasearchservice.service.AeroportoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "API de Aeroportos")
@RestController
@RequestMapping("/api/v1/aeroportos")
public class AeroportoController {

	@Autowired
	private AeroportoService aeroportoService;

	@Operation(summary = "Buscar aeroporto por id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = Aeroporto.class))),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = StandardError.class))),
			@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema(implementation = StandardError.class))),
			@ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema(implementation = StandardError.class))),
			@ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = StandardError.class))),
			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = StandardError.class)))

	})
	@GetMapping("/{id}")
	public ResponseEntity<Aeroporto> buscarAeroportoId(@PathVariable("id") Long id) {
		return ResponseEntity.ok().body(aeroportoService.buscarAeroportoId(id));
	}
	
	@Operation(summary = "Listar aeroportos")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = AeroportoResponseDTO.class))),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = StandardError.class))),
			@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema(implementation = StandardError.class))),
			@ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema(implementation = StandardError.class))),
			@ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = StandardError.class))),
			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = StandardError.class)))

	})
	@GetMapping
	public ResponseEntity<AeroportoResponseDTO> listarAeroportos(){
		return ResponseEntity.ok().body(aeroportoService.listarAeroportos());
		
	}
	
	@Operation(summary = "Listar aeroportos brasileiros")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = AeroportoResponseDTO.class))),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = StandardError.class))),
			@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema(implementation = StandardError.class))),
			@ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema(implementation = StandardError.class))),
			@ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = StandardError.class))),
			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = StandardError.class)))

	})
	@GetMapping("/brasileiros")	
	public ResponseEntity<List<Aeroporto>> listarAeroportosBrasileiros(){
		return ResponseEntity.ok().body(aeroportoService.listarAeroportosBrasileiros());
		
	}
	
	@Operation(summary = "Inserir aeroporto")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Created", content = @Content(schema = @Schema(implementation = Aeroporto.class))),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = StandardError.class))),
			@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema(implementation = StandardError.class))),
			@ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema(implementation = StandardError.class))),
			@ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = StandardError.class))),
			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = StandardError.class)))

	})	
	@PostMapping
	public ResponseEntity<Aeroporto> inserirAeroporto(@Valid @RequestBody AeroportoDTO dto){
		Aeroporto aeroporto = aeroportoService.inserirAeroporto(dto);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(aeroporto.getId()).toUri();
		
		return ResponseEntity.created(location).body(aeroporto);
	}
	
	@Operation(summary = "Alterar aeroporto")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204", description = "No Content", content = @Content(schema = @Schema(implementation = Void.class))),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = StandardError.class))),
			@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema(implementation = StandardError.class))),
			@ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema(implementation = StandardError.class))),
			@ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = StandardError.class))),
			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = StandardError.class)))

	})	
	@PutMapping("/{id}")
	public ResponseEntity<Void> alterarAeroporto(@PathVariable("id") Long id, @Valid @RequestBody AeroportoDTO dto){
		aeroportoService.alterarAeroporto(id,dto);
		
		return ResponseEntity.noContent().build();
	}
	
	
}
