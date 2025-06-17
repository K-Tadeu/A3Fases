public class MainFase1 {

    public static void main(String[] args) {
        ParserFase1 parser = new ParserFase1();
        try {

            // Insira o local onde está localizado o arquivo aqui:
            parser.executar("C:\\Users\\822145075\\Documents\\edaa\\A3\\A3Fases\\resourcesFase1\\fase1_entrada.txt", "C:\\Users\\822145075\\Documents\\edaa\\A3\\A3Fases\\resourcesFase1\\fase1_saida_gerado.txt");
            System.out.println("Processamento concluído. Verifique o arquivo de saída.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
