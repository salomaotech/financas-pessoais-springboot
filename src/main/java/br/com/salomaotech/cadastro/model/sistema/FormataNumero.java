package br.com.salomaotech.cadastro.model.sistema;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * Formatador de numeros
 *
 * @author @salomaotech
 */
public class FormataNumero {

    /**
     * Converte para BigDecimal
     *
     * @param numero Número a ser formatado
     * @return Retorna o valor no formato BigDecimal
     */
    public static BigDecimal formatarNumero(String numero) {

        /* excessão */
        try {

            /* número convertido */
            String numeroConvertido = numero;

            /* se houver ponto e virgula remove o ponto separador de milhar exemplo 1.500,36 vira 1500,36*/
            if (numero.contains(".") & numero.contains(",")) {

                /* remove o ponto */
                numeroConvertido = numero.replace(".", "");

            }

            /* converte a virgula em ponto para separar números quebrados */
            numero = numeroConvertido.replace(",", ".");

            /* retorno */
            return new BigDecimal(numero);

        } catch (java.lang.NumberFormatException | java.lang.NullPointerException | java.lang.ClassCastException ex) {

            /* retorno */
            return new BigDecimal("0");

        }

    }

    /**
     * Cifrar
     *
     * @param numero Número a ser cifrado
     * @return Número no formato R$ 299,99
     */
    public static String formatarNumeroParaBr(String numero) {

        /* trata excessão */
        try {

            /* BigDecimal */
            BigDecimal valor = formatarNumero(numero);

            /* formata o numero */
            NumberFormat nf = NumberFormat.getCurrencyInstance();

            /* retorno */
            return nf.format(valor);

        } catch (java.lang.NumberFormatException ex) {

            /* retorno */
            return "";

        }

    }

}
