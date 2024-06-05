package menu;

import conversorApi.Conversor;
import conversorApi.ConversorApi;

import java.util.Scanner;

public class Menu {
    Scanner numeroEscolha = new Scanner(System.in);

    public void menu(){
        boolean exibeMenu = true;
        while (exibeMenu){
            System.out.println("""
                ==============================================
                ##### Bem-vindo ao Conversor de Moedas! #####
                ==============================================

                        1) Real  ==> Dólar
                        2) Dólar ==> Real
                        3) Real  ==> Euro
                        4) Euro  ==> Real
                        5) Real  ==> Peso Argentino
                        6) Peso Argentino ==> Real
                        7) Sair =>

                ==============================================
                """);

                System.out.println("Digite o número da opção de conversão desejada: ");
                String opcao = numeroEscolha.next();

                switch (opcao){
                    case "1":
                        this.converter("BRL","USD");
                        break;

                    case "2":
                        this.converter("USD","BRL");
                        break;

                    case "3":
                        this.converter("BRL","EUR");
                        break;

                    case "4":
                        this.converter("EUR","BRL" );
                        break;

                    case "5":
                        this.converter("BRL","ARS");
                        break;

                    case "6":
                        this.converter("ARS","BRL" );
                        break;

                    default:
                        if (opcao.equals("7")){
                            System.out.println("Obrigado !!");
                            exibeMenu = false;
                        }else {
                            System.out.println("Opção Inválida ! " +
                                    "Selecione uma opção valida, ou, Opção \"7\" para sair. ");
                        }
                        break;
                }
            }
        }

        public void converter (String baseCode, String targetCode){
            System.out.println("Informe um valor para conversão: ");
            try {
                double valor = this.numeroEscolha.nextDouble();
                Conversor conversor = new Conversor(baseCode, targetCode, valor);
                ConversorApi api = new ConversorApi(conversor);
                System.out.println(api.chamadaApi());
            } catch (Exception e) {
                System.out.println("Valor digitado é inválido... Utilize ',' para converter numeros decimais.");
            }

        }
    }
