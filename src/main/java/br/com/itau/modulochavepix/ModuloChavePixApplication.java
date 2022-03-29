package br.com.itau.modulochavepix;

import br.com.itau.modulochavepix.api.ValidaChavePix;
import br.com.itau.modulochavepix.api.validation.ChavePixValidator;
import br.com.itau.modulochavepix.dto.ResponseJSONMessage;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class ModuloChavePixApplication {

	@Bean
	public ChavePixValidator chavePixValidator (){
		return new ChavePixValidator();
	}

	@Bean
	public ResponseJSONMessage responseJSONMessage(){
		return new ResponseJSONMessage();
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(ModuloChavePixApplication.class, args);
	}

}
