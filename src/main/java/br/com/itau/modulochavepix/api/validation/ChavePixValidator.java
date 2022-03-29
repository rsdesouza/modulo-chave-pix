package br.com.itau.modulochavepix.api.validation;

import br.com.itau.modulochavepix.exception.BusinessException;

public class ChavePixValidator {

    public void checkTipoChave(String tipoChave) throws BusinessException {
        if (stringIsNullOrEmpty(tipoChave))
            throw new BusinessException("O tipo de chave não deve ser nulo!");

        if (!tipoChave.equals("celular") && !tipoChave.equals("email") && !tipoChave.equals("cpf")
                && !tipoChave.equals("cnpj") && !tipoChave.equals("aleatorio"))
            throw new BusinessException("Tipo de chave inválido! Deve ser 'celular', 'email', 'cpf', 'cnpj' ou 'aleatorio'");
    }

    public void checkTipoConta(String tipoConta) throws BusinessException {
        if (stringIsNullOrEmpty(tipoConta))
            throw new BusinessException("O tipo de conta não deve ser nulo ou vazio!");

        if (tipoConta.length() > 10)
            throw new BusinessException("O tipo de conta deve ter no máximo 10 caracteres");

        if (!tipoConta.equals("corrente") && !tipoConta.equals("poupanca"))
            throw new BusinessException("Valores de tipo de conta inválidos! Deve ser 'corrente' ou 'poupanca'");
    }

    public void checkNumeroAgencia(Long numAgencia) throws BusinessException {
        if (longIsNullOrZero(numAgencia))
            throw new BusinessException("O número da agência não deve ser nulo!");

        if (String.valueOf(numAgencia).length() > 4)
            throw new BusinessException("O número da agência deve ter no máximo 4 dígitos");
    }

    public void checkNumeroConta(Long numConta) throws BusinessException {
        if (longIsNullOrZero(numConta))
            throw new BusinessException("O número da conta não deve ser nulo!");

        if (String.valueOf(numConta).length() > 8)
            throw new BusinessException("O número da agência deve ter no máximo 8 dígitos");
    }

    public void checkChaveValorGenerica(String chaveValor) throws BusinessException {
        if (stringIsNullOrEmpty(chaveValor))
            throw new BusinessException("O valor da chave não deve ser nulo ou vazio!");
    }

    public void checkNumeroCelular(String numeroCelular) throws BusinessException {
        if (!numeroCelular.contains("+55"))
            throw new BusinessException("O telefone deve conter o código de país '+55'!");

        boolean keyTypeHasLetters = checkIfStringContainLetters(numeroCelular);
        if (keyTypeHasLetters)
            throw new BusinessException("O telefone deve conter apenas números!");

        if (numeroCelular.length() < 15)
            throw new BusinessException("O telefone deve ter no máximo 15 dígitos! Exemplo: +550819986664575");
    }

    public void checkEmail(String email) throws BusinessException {
        if (!email.contains("@"))
            throw new BusinessException("O e-mail deve conter o caractere @!");

        if (email.length() > 77)
            throw new BusinessException("O comprimento do e-mail deve ter no máximo 77 caracteres.");
    }

    public void checkCPF(String cpf) throws BusinessException {
        if (cpf.length() != 11)
            throw new BusinessException("O comprimento do CPF deve conter 11 dígitos!");
    }

    public void checkCNPJ(String cnpj) throws BusinessException {
        if (cnpj.length() != 14)
            throw new BusinessException("O comprimento do CNPJ deve conter 14 dígitos!");
    }

    public void checkChaveAleatoria(String chaveAleatoria) throws BusinessException {
        if (chaveAleatoria.length() > 36)
            throw new BusinessException("A chave aleatória deve ter um comprimento máximo de 36 caracteres.");
    }

    public void checkTipoPessoa(String tipoPessoa) throws BusinessException {
        if (stringIsNullOrEmpty(tipoPessoa))
            throw new BusinessException("O tipo de pessoa não deve ser nulo ou vazio!");

        if (!tipoPessoa.equals("fisica") && !tipoPessoa.equals("juridica"))
            throw new BusinessException("O tipo de pessoa deve ser 'fisica' ou 'juridica'");
    }

    public void checkNomeCorrentista(String name) throws BusinessException {
        if (stringIsNullOrEmpty(name))
            throw new BusinessException("O nome do correntista não deve ser nulo ou vazio!");

        if (name.length() > 30)
            throw new BusinessException("O nome do correntista deve ter no máximo 30 caracteres");
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
