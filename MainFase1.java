public class MainFase1 {

    public static void main(String[] args) {
        ParserFase1 parser = new ParserFase1();
        try {
            // Ajuste o caminho conforme onde você colocou os arquivos
            parser.executar("C:\\Users\\822145075\\Documents\\Estrutura de Dados\\a3\\fase1_entrada.txt", "C:\\Users\\822145075\\Documents\\Estrutura de Dados\\a3\\fase1_saida_gerado.txt");
            System.out.println("Processamento concluído. Verifique o arquivo de saída.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
