package br.com.baratasearch.baratasearchservice.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.baratasearch.baratasearchservice.dto.VooDTO;
import br.com.baratasearch.baratasearchservice.dto.VooGoogleDTO;
import br.com.baratasearch.baratasearchservice.dto.VooResponseDTO;
import br.com.baratasearch.baratasearchservice.entity.Voo;
import br.com.baratasearch.baratasearchservice.exception.StandardError;
import br.com.baratasearch.baratasearchservice.model.Aeroportos;
import br.com.baratasearch.baratasearchservice.service.ScrapingService;
import br.com.baratasearch.baratasearchservice.service.VooService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "API de Voos")
@RestController
@RequestMapping("api/v1/voos")
public class VooController {

	@Autowired
	private Aeroportos aeroportos;
	
	@Autowired
	private VooService vooService;

	@Autowired
	private ScrapingService scrapingService;

	@Operation(summary = "Buscar voo por id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = Voo.class))),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = StandardError.class))),
			@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema(implementation = StandardError.class))),
			@ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema(implementation = StandardError.class))),
			@ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = StandardError.class))),
			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = StandardError.class)))

	})
	@GetMapping("/{id}")
	public ResponseEntity<Voo> buscarVooId(@PathVariable("id") Long id) {
		return ResponseEntity.ok().body(vooService.buscarVooId(id));
	}

	@Operation(summary = "Listar voos do banco")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = VooResponseDTO.class))),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = StandardError.class))),
			@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema(implementation = StandardError.class))),
			@ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema(implementation = StandardError.class))),
			@ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = StandardError.class))),
			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = StandardError.class)))

	})
	@GetMapping
	public ResponseEntity<VooResponseDTO> listarVoos() {
		return ResponseEntity.ok().body(vooService.listarVoos());

	}

	@Operation(summary = "Buscar e inserir voos do GoogleFlights")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = VooResponseDTO.class))),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = StandardError.class))),
			@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema(implementation = StandardError.class))),
			@ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema(implementation = StandardError.class))),
			@ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = StandardError.class))),
			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = StandardError.class)))

	})
	@PostMapping("/GoogleFlights")
	public ResponseEntity<?> buscarVoosGoogleFlights(
			@Parameter(description = "Aeroporto de Partida", required = true) @RequestParam String aeroportoPartida,
			@Parameter(description = "Aeroporto de destino", required = true) @RequestParam String aeroportoDestino,
			@Parameter(description = "Data de partida", required = true) @RequestParam String dataPartida,
			@Parameter(description = "Data de destino", required = false) @RequestParam(required = false) String dataDestino) {
		ArrayList<VooGoogleDTO> voosDefinidos= null;
		
		voosDefinidos = scrapingService.buscaVoosDefinidos(aeroportoPartida, aeroportoDestino, dataPartida, dataDestino, voosDefinidos);
		
		aeroportoPartida = aeroportos.getSiglaAeroporto(aeroportoPartida);
		aeroportoDestino = aeroportos.getSiglaAeroporto(aeroportoDestino);
		
		ArrayList<Voo> resultVoos;
		if (dataDestino == null) {
			resultVoos = vooService.inserirListaVooIda(voosDefinidos, aeroportoPartida, aeroportoDestino, dataPartida);
		} else {
			resultVoos = vooService.inserirVooListaIdaEvolta(voosDefinidos, aeroportoPartida, aeroportoDestino, dataPartida, dataDestino);
		}
		if (voosDefinidos != null) {
		return ResponseEntity.ok().body(resultVoos);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

	@Operation(summary = "Inserir voo")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Created", content = @Content(schema = @Schema(implementation = Voo.class))),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = StandardError.class))),
			@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema(implementation = StandardError.class))),
			@ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema(implementation = StandardError.class))),
			@ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = StandardError.class))),
			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = StandardError.class))) })
	@PostMapping
	public ResponseEntity<Voo> inserirVoo(@Valid @RequestBody VooDTO dto,
			@Parameter(description = "Data de partida", required = true) @RequestParam String dataPartida,
			@Parameter(description = "Data de destino", required = false) @RequestParam(required = false) String dataDestino) {
		Voo voo;
		if (dataDestino == null) {
			voo = vooService.inserirVooIda(dto, dataPartida);
		} else {
			voo = vooService.inserirVooIdaEvolta(dto, dataPartida, dataDestino);
		}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(voo.getId())
				.toUri();

		return ResponseEntity.created(location).body(voo);
	}

	@Operation(summary = "Alterar voo")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204", description = "No Content", content = @Content(schema = @Schema(implementation = Void.class))),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = StandardError.class))),
			@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema(implementation = StandardError.class))),
			@ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema(implementation = StandardError.class))),
			@ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = StandardError.class))),
			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = StandardError.class)))

	})
	@PutMapping("/{id}")
	public ResponseEntity<Void> alterarVoo(@PathVariable("id") Long id, @Valid @RequestBody VooDTO dto) {
		vooService.alterarVoo(id, dto);

		return ResponseEntity.noContent().build();
	}

}
