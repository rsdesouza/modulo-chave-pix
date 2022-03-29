package br.com.itau.modulochavepix.api.validation;

import br.com.itau.modulochavepix.exception.ValidationException;

public class ChavePixValidator {

    public void checkTipoChave(String tipoChave) throws ValidationException {
        if (stringIsNullOrEmpty(tipoChave))
            throw new ValidationException("O tipo de chave não deve ser nulo!");

        if (!tipoChave.equals("celular") && !tipoChave.equals("email") && !tipoChave.equals("cpf")
                && !tipoChave.equals("cnpj") && !tipoChave.equals("aleatorio"))
            throw new ValidationException("Tipo de chave inválido! Deve ser 'celular', 'email', 'cpf', 'cnpj' ou 'aleatorio'");
    }

    public void checkTipoConta(String tipoConta) throws ValidationException {
        if (stringIsNullOrEmpty(tipoConta))
            throw new ValidationException("O tipo de conta não deve ser nulo ou vazio!");

        if (tipoConta.length() > 10)
            throw new ValidationException("O tipo de conta deve ter no máximo 10 caracteres");

        if (!tipoConta.equals("corrente") && !tipoConta.equals("poupanca"))
            throw new ValidationException("Valores de tipo de conta inválidos! Deve ser 'corrente' ou 'poupanca'");
    }

    public void checkNumeroAgencia(Long numAgencia) throws ValidationException {
        if (longIsNullOrZero(numAgencia))
            throw new ValidationException("O número da agência não deve ser nulo!");

        if (String.valueOf(numAgencia).length() > 4)
            throw new ValidationException("O número da agência deve ter no máximo 4 dígitos");
    }

    public void checkNumeroConta(Long numConta) throws ValidationException {
        if (longIsNullOrZero(numConta))
            throw new ValidationException("O número da conta não deve ser nulo!");

        if (String.valueOf(numConta).length() > 8)
            throw new ValidationException("O número da agência deve ter no máximo 8 dígitos");
    }

    public void checkChaveValorGenerica(String chaveValor) throws ValidationException {
        if (stringIsNullOrEmpty(chaveValor))
            throw new ValidationException("O valor da chave não deve ser nulo ou vazio!");
    }

    public void checkNumeroCelular(String numeroCelular) throws ValidationException {
        if (!numeroCelular.contains("+55"))
            throw new ValidationException("O telefone deve conter o código de país '+55'!");

        boolean keyTypeHasLetters = checkIfStringContainLetters(numeroCelular);
        if (keyTypeHasLetters)
            throw new ValidationException("O telefone deve conter apenas números!");

        if (numeroCelular.length() < 15)
            throw new ValidationException("O telefone deve ter no máximo 15 dígitos! Exemplo: +550819986664575");
    }

    public void checkEmail(String email) throws ValidationException {
        if (!email.contains("@"))
            throw new ValidationException("O e-mail deve conter o caractere @!");

        if (email.length() > 77)
            throw new ValidationException("O comprimento do e-mail deve ter no máximo 77 caracteres.");
    }

    public void checkCPF(String cpf) throws ValidationException {
        if (cpf.length() != 11)
            throw new ValidationException("O comprimento do CPF deve conter 11 dígitos!");
    }

    public void checkCNPJ(String cnpj) throws ValidationException {
        if (cnpj.length() != 14)
            throw new ValidationException("O comprimento do CNPJ deve conter 14 dígitos!");
    }

    public void checkChaveAleatoria(String chaveAleatoria) throws ValidationException {
        if (chaveAleatoria.length() > 36)
            throw new ValidationException("A chave aleatória deve ter um comprimento máximo de 36 caracteres.");
    }

    public void checkTipoPessoa(String tipoPessoa) throws ValidationException {
        if (stringIsNullOrEmpty(tipoPessoa))
            throw new ValidationException("O tipo de pessoa não deve ser nulo ou vazio!");

        if (!tipoPessoa.equals("fisica") && !tipoPessoa.equals("juridica"))
            throw new ValidationException("O tipo de pessoa deve ser 'fisica' ou 'juridica'");
    }

    public void checkNomeCorrentista(String name) throws ValidationException {
        if (stringIsNullOrEmpty(name))
            throw new ValidationException("O nome do correntista não deve ser nulo ou vazio!");

        if (name.length() > 30)
            throw new ValidationException("O nome do correntista deve ter no máximo 30 caracteres");
    }

    private boolean stringIsNullOrEmpty(String text) {
        return text == null || text.equals("");
    }
    private boolean longIsNullOrZero(Long numero) {
        return numero == null || numero.equals(numero.longValue() == 0L);
    }
    private boolean checkIfStringContainLetters(String text){
        char[] chars = text.toCharArray();
        for(char c : chars)
            if(Character.isLetter(c)){
                return true;
            }

        return false;
    }
}
