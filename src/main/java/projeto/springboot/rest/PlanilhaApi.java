package projeto.springboot.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import projeto.springboot.constante.MensagemEnum;
import projeto.springboot.representation.RequestPlanilhaRepresentation;
import projeto.springboot.representation.ResponsePlanilhaRepresentation;
import projeto.springboot.representation.ResponseRepresentation;
import projeto.springboot.service.PlanilhaService;

@Api(value = "API REST Planilha")
@RestController
@RequestMapping("/v1/planilhaApi")
public class PlanilhaApi {

	@Autowired
	PlanilhaService planilhaService;

	@ApiOperation(value = "Consultar planilha")
	@GetMapping(path= "/consultar")
	public @ResponseBody
	ResponsePlanilhaRepresentation listarPlanilha() throws Exception {
		return planilhaService.consultarPlanilha();
	}

	@ApiOperation(value = "Alterar planilha - Para Alterar por favor passar a linha, a coluna em abecedario: 'A/B/C/D/E...' e o valor."
			+ "Cada Planilha equivale a uma linha e coluna alterado"
			+ "Precisa passar uma lista de Planilha")
	@PostMapping(path = "/alterarPlanilha")
	public ResponseEntity<ResponseRepresentation> alterarPlanilha(
			@Valid @RequestBody RequestPlanilhaRepresentation request) {
		try {
			return new ResponseEntity<>(
					planilhaService.alterarPlanilha(request), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseRepresentation(
					MensagemEnum.MENSAGEM_ERROR), HttpStatus.BAD_REQUEST);
		}
	}
}
