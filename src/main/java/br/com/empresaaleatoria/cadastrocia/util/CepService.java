package br.com.empresaaleatoria.cadastrocia.util;

import static java.util.Objects.isNull;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.empresaaleatoria.cadastrocia.model.Endereco;
import jakarta.persistence.EntityNotFoundException;

@Component
public class CepService {

	private final static String URL_CORREIOS = "https://viacep.com.br/ws/{cep}/json/";
	
	private static WebClient webClient;
	

	public CepService(WebClient.Builder webClientBuilder) {
        CepService.webClient = webClientBuilder.baseUrl(URL_CORREIOS).build();
    }

	public static void preencherEnderecoComCep(Endereco endereco, String cep) {
        String url = URL_CORREIOS.replace("{cep}", cep);

        CepResponse cepResponse = webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(CepResponse.class)
                .block();
                
		if (isNull(cepResponse.getCep())) {
			throw new EntityNotFoundException("CEP inválido");
		}
			endereco.setLogradouro(cepResponse.getLogradouro());
			endereco.setBairro(cepResponse.getBairro());
			endereco.getCidade().setMunicipio(cepResponse.getLocalidade());
			endereco.getCidade().setUf(cepResponse.getUf());
			endereco.getCidade().setIbge(cepResponse.getIbge());
			endereco.setCep(cepResponse.getCep().replace("-", ""));
	}

}
