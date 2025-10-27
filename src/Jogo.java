package RPG;

import java.util.Random;

public class Jogo {

    private Personagem jogador;
    private Random dado;
    private String localizacaoAtual;

    public Jogo() throws Exception {
        this.dado = new Random();
        this.jogador = criarPersonagem();
        this.localizacaoAtual = "Sala de Aula - Bloco C";
    }

    public void iniciarJogo() throws Exception {
        System.out.println("Durante uma tarde comum de aulas, uma nave alienígena cai...");
        System.out.println("Você se vê preso em uma " + this.localizacaoAtual + ".");

        while (this.jogador.getPontosVida() > 0) {
            exibirMenuPrincipal();
        }

        System.out.println("GAME OVER... Você foi derrotado.");
    }

    private void exibirMenuPrincipal() throws Exception {
        System.out.println("\n----------------------------------------");
        System.out.println("Você está em: " + this.localizacaoAtual);
        System.out.println("HP: " + this.jogador.getPontosVida());
        System.out.println("O que você deseja fazer?");
        System.out.println("1. Explorar o local");
        System.out.println("2. Mover-se para outro local");
        System.out.println("3. Ver Inventário / Usar Item");
        System.out.print("Escolha: ");

        int escolha;
        try {
            escolha = Teclado.getUmInt();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            escolha = 0; // Opção inválida
        }

        switch (escolha) {
            case 1:
                explorar();
                break;
            case 2:
                navegar();
                break;
            case 3:
                abrirInventario();
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private Personagem criarPersonagem() throws Exception {
        System.out.println("Os invasores estão por toda parte! Quem é você?");
        System.out.println("1. O Atleta (Curso: Educação Física) - Foco em HP e Defesa.");
        System.out.println("2. O Programador (Curso: Eng. de Software) - Foco em Ataque.");
        System.out.println("3. O Arquiteto (Curso: Arquitetura) - Atributos mais balanceados.");
        System.out.print("Escolha sua classe: ");

        int classe = Teclado.getUmInt();

        System.out.print("Digite o nome do seu personagem: ");
        String nome = Teclado.getUmString();

        Personagem p;

        switch (classe) {
            case 1:
                System.out.println("Você é 'O Atleta'! Foco em resistir ao combate.");
                p = new Guerreiro(nome);
                break;

            case 2:
                System.out.println("Você é 'O Programador'! Usando lógica para atacar.");
                p = new Mago(nome);
                break;

            case 3:
                System.out.println("Você é 'O Arquiteto'! Precisão é sua arma.");
                p = new Arqueiro(nome);
                break;

            default:
                System.out.println("Opção inválida. Escolhendo 'O Atleta' por padrão.");
                p = new Guerreiro(nome);
                break;
        }

        System.out.println(nome + " se junta à luta!");
        return p;
    }

    private void navegar() {
        System.out.println("De " + this.localizacaoAtual + ", você pode ir para:");
        int escolha;

        try {
            switch (this.localizacaoAtual) {
                case "BLOCO C":
                    System.out.println("1. BLOCO A");
                    escolha = Teclado.getUmInt();
                    if (escolha == 1) this.localizacaoAtual = "BLOCO A";
                    else System.out.println("Opção inválida. Você permanece no local.");
                    break;

                case "BLOCO A":
                    System.out.println("1. ESTACIONAMENTO");
                    escolha = Teclado.getUmInt();
                    if (escolha == 1) this.localizacaoAtual = "ESTACIONAMENTO";
                    else System.out.println("Opção inválida. Você permanece no local.");
                    break;

                case "ESTACIONAMENTO":
                    System.out.println("1. H-1 (Caminho da Esquerda)");
                    System.out.println("2. H-2 (Caminho da Direita)");
                    escolha = Teclado.getUmInt();
                    if (escolha == 1) this.localizacaoAtual = "H-1";
                    else if (escolha == 2) this.localizacaoAtual = "H-2";
                    else System.out.println("Opção inválida. Você permanece no local.");
                    break;

                // --- ROTA DA DIREITA ---
                case "H-1":
                    System.out.println("1. CAA");
                    escolha = Teclado.getUmInt();
                    if (escolha == 1) this.localizacaoAtual = "CAA";
                    else System.out.println("Opção inválida. Você permanece no local.");
                    break;

                case "CAA":
                    System.out.println("1. MESCLA");
                    System.out.println("2. PRAÇA ALIMENTACAO");
                    escolha = Teclado.getUmInt();
                    if (escolha == 1) this.localizacaoAtual = "MESCLA";
                    else if (escolha == 2) this.localizacaoAtual = "PRAÇA ALIMENTACAO";
                    else System.out.println("Opção inválida. Você permanece no local.");
                    break;

                case "MESCLA":
                    System.out.println("1. BIBLIOTECA");
                    escolha = Teclado.getUmInt();
                    if (escolha == 1) this.localizacaoAtual = "BIBLIOTECA";
                    else System.out.println("Opção inválida. Você permanece no local.");
                    break;

                case "BIBLIOTECA":
                    System.out.println("1. PRAÇA ALIMENTACAO");
                    escolha = Teclado.getUmInt();
                    if (escolha == 1) this.localizacaoAtual = "PRAÇA ALIMENTACAO";
                    else System.out.println("Opção inválida. Você permanece no local.");
                    break;

                // --- ROTA DA ESQUERDA ---
                case "H-2":
                    System.out.println("1. H-8");
                    escolha = Teclado.getUmInt();
                    if (escolha == 1) this.localizacaoAtual = "H-8";
                    else System.out.println("Opção inválida. Você permanece no local.");
                    break;

                case "H-8":
                    System.out.println("1. MANACÁS");
                    System.out.println("2. CAPELA");
                    escolha = Teclado.getUmInt();
                    if (escolha == 1) this.localizacaoAtual = "MANACÁS";
                    else if (escolha == 2) this.localizacaoAtual = "CAPELA";
                    else System.out.println("Opção inválida. Você permanece no local.");
                    break;

                case "MANACÁS":
                    System.out.println("1. H-14");
                    System.out.println("2. H-12");
                    System.out.println("3. PRAÇA ALIMENTACAO");
                    escolha = Teclado.getUmInt();
                    if (escolha == 1) this.localizacaoAtual = "H-14";
                    else if (escolha == 2) this.localizacaoAtual = "H-12";
                    else if (escolha == 3) this.localizacaoAtual = "PRAÇA ALIMENTACAO";
                    else System.out.println("Opção inválida. Você permanece no local.");
                    break;

                case "CAPELA":
                    System.out.println("1. PRAÇA ALIMENTACAO");
                    escolha = Teclado.getUmInt();
                    if (escolha == 1) this.localizacaoAtual = "PRAÇA ALIMENTACAO";
                    else System.out.println("Opção inválida. Você permanece no local.");
                    break;

                case "H-12":
                    System.out.println("1. PRAÇA ALIMENTACAO");
                    escolha = Teclado.getUmInt();
                    if (escolha == 1) this.localizacaoAtual = "PRAÇA ALIMENTACAO";
                    else System.out.println("Opção inválida. Você permanece no local.");
                    break;

                case "H-14":
                    System.out.println("1. PRAÇA ALIMENTACAO");
                    escolha = Teclado.getUmInt();
                    if (escolha == 1) this.localizacaoAtual = "PRAÇA ALIMENTACAO";
                    else System.out.println("Opção inválida. Você permanece no local.");
                    break;

                // --- CAMINHO FINAL ---
                case "PRAÇA ALIMENTACAO":
                    System.out.println("1. CT-A");
                    escolha = Teclado.getUmInt();
                    if (escolha == 1) this.localizacaoAtual = "CT-A";
                    else System.out.println("Opção inválida. Você permanece no local.");
                    break;

                case "CT-A":
                    System.out.println("1. H-15 (FIM)");
                    escolha = Teclado.getUmInt();
                    if (escolha == 1) this.localizacaoAtual = "H-15 (FIM)";
                    else System.out.println("Opção inválida. Você permanece no local.");
                    break;

                case "H-15 (FIM)":
                    System.out.println("Você chegou ao seu destino final. Não há para onde ir.");
                    System.out.println("Explore o local para o confronto final!");
                    break;

                default:
                    System.out.println("Erro: Localização desconhecida. Você permanece no local.");
                    break;
            }
        } catch (Exception e) {
            System.err.println("Opção de navegação inválida.");
        }
    }

    private void explorar() throws Exception {
        System.out.println("Você explora " + this.localizacaoAtual + "...");

        switch (this.localizacaoAtual) {
            case "BLOCO C":
                explorarBlocoC();
                break;
            case "PRAÇA ALIMENTACAO":
                explorarPracaAlimentacao();
                break;
            case "H-8":
                explorarH8();
                break;
            case "BIBLIOTECA":
                explorarBiblioteca();
                break;
            case "H-15 (FIM)":
                explorarH15();
                break;
            case "ESTACIONAMENTO":
                explorarEstacionamento();
                break;
            // Adicione 'case' para outros locais que você quer detalhar
            default:
                // Evento genérico para locais que não tem uma função própria
                System.out.println("Nada de interessante por aqui.");
                int chance = dado.nextInt(100);
                if (chance < 20) { // 20% de chance de batalha em locais genéricos
                    System.out.println("Um Drone de Patrulha te avista!");
                    Inimigo inimigo = Inimigo.gerarInimigo(this.localizacaoAtual);
                    iniciarBatalha(inimigo);
                }
        }
    }

    // --- MÉTODOS DE EXPLORAR LOCAIS ESPECÍFICOS

    private void explorarCT() throws Exception{
        System.out.println("Você encontra o Supervisor Alienígena, chamado BENIGNO, e seu esquadrão!");
        System.out.println("Se prepare para uma onda de inimigos!");

        Inimigo inimigo = Inimigo.gerarInimigo("Praça de alimentação");
        iniciarBatalha(inimigo);

        inimigo = Inimigo.gerarInimigo("Praça de alimentação"); //Gera um outro inimigo
        iniciarBatalha(inimigo);

        inimigo = Inimigo.gerarInimigo("Praça de alimentação");//Gera um OUTRO inimigo
        iniciarBatalha(inimigo);

        Inimigo chefe = new Inimigo("Benigno", 200, 30, 30, (short) 8);
        chefe.getInventario().adicionarItem(new Item("Chave da Sala dos Professores", "Destranca a sala dos professores no H-15", "ITEM", 1, 0));

        //SERIA BOM COLOCAR UMA FUNÇÃO ONDE VOCÊ SÓ PODE NAVEGAR PRO H15 QUANDO VOCÊ TEM A CHAVE DA SALA DOS PROFESSORES,
        //ATUALMENTE VOCÊ SÓ PODE IR LÁ DIRETO E ISSO NÃO É BOM! Também poderia fazer mais itens chave assim para os outros lugares,
        //por que atualmente você só pode navegar direto por todos os lugares sem ter que fazer nada e ir direto pro boss final.
    }

    private void explorarPracaAlimentacao() throws Exception {
        System.out.println("A Praça de Alimentação está um caos. Mesas viradas e comida espalhada.");
        System.out.println("O que você quer investigar?");
        System.out.println("1. A Lanchonete Papa João XXIII (parece intacta)");
        System.out.println("2. O restaurante Palatus (parece um tanto perigoso)");
        System.out.println("3. Sair");

        int escolha = Teclado.getUmInt();

        int chance = dado.nextInt(100);
        if (escolha == 1) {
            if(chance > 20){
                System.out.println("Você vasculha a lanchonete e encontra um Salgado!");
                Item salgado = new Item("Salgado", "Cura 20 HP", "CURA_HP", 1, 20);
                this.jogador.getInventario().adicionarItem(salgado);
            }
            else{
                System.out.println("Você vasculha a lanchonete e encontra um inimigo!");
                Inimigo inimigo = Inimigo.gerarInimigo("Praça de alimentação");
                iniciarBatalha(inimigo);
            }
        } else if (escolha == 2) {
            if(chance > 75){
                System.out.println("O lugar está destruído, mas nos destroços você encontrou um Energético!");
                Item energetico = new Item("Energético", "Aumenta o Ataque em 10", "BUFF_ATK", 1, 10);
                this.jogador.getInventario().adicionarItem(energetico);
            }
            else{
                System.out.println("Você vasculha os destroços do restaurante e encontra um inimigo!");
                Inimigo inimigo = Inimigo.gerarInimigo("Praça de alimentação");
                iniciarBatalha(inimigo);
            }
        } else {
            System.out.println("Você decide não arriscar e sai.");
        }
    }

    private void explorarH8() throws Exception {
        System.out.println("Este é o Bloco H-8, da Escola de Economia e Negócios. As salas de aula e escritórios estão revirados.");
        System.out.println("Você vê a copa dos professores com a porta arrombada.");
        System.out.println("O que você faz?");
        System.out.println("1. Procurar na máquina de café");
        System.out.println("2. Vasculhar o armário de suprimentos");
        System.out.println("3. Ignorar e sair");

        int escolha = Teclado.getUmInt();

        if (escolha == 1) {
            System.out.println("Você encontra uma cápsula de 'Café Forte'!");
            Item cafe = new Item("Café Forte", "Aumenta o Ataque em 5", "BUFF_ATK", 1, 5);
            this.jogador.getInventario().adicionarItem(cafe);
        } else if (escolha == 2) {
            System.out.println("Você acha um 'Kit de Primeiros Socorros' padrão de escritório.");
            Item kit = new Item("Kit de Primeiros Socorros", "Recupera 75 HP", "CURA_HP", 1, 75);
            this.jogador.getInventario().adicionarItem(kit);
        } else {
            System.out.println("Você deixa os suprimentos para trás.");
        }
    }

    private void explorarEstacionamento() throws Exception {
        System.out.println("O estacionamento está cheio de carros batidos. Fumaça sai de um drone caído.");
        System.out.println("De repente, um alarme de carro dispara alto!");
        System.out.println("O que você faz?");
        System.out.println("1. Investigar o som (Pode ser perigoso)");
        System.out.println("2. Se afastar silenciosamente");

        int escolha = Teclado.getUmInt();

        if (escolha == 1) {
            System.out.println("Você se aproxima do carro e um 'Soldado Invasor' que estava escondido te ataca!");
            Inimigo inimigo = Inimigo.gerarInimigo(this.localizacaoAtual);
            iniciarBatalha(inimigo);
        } else {
            System.out.println("Você decide não arriscar e se esgueira para a próxima área.");
        }
    }

    private void explorarBiblioteca() throws Exception {
        System.out.println("A Biblioteca está silenciosa, exceto pelos livros caídos no chão.");
        System.out.println("Você encontra a mochila de outro estudante caída perto de uma mesa.");
        System.out.println("O que você faz?");
        System.out.println("1. Vasculhar a mochila por itens");
        System.out.println("2. Deixar para lá");

        int escolha = Teclado.getUmInt();

        if (escolha == 1) {
            System.out.println("Você vasculhou a mochila e encontrou:");

            Item refrigerante = new Item("Refrigerante", "Recupera 10 HP", "CURA_HP", 2, 10);
            this.jogador.getInventario().adicionarItem(refrigerante);
            System.out.println("- Refrigerante (x2)");

            Item cafe = new Item("Café Forte", "Aumenta o Ataque em 5", "BUFF_ATK", 1, 5);
            this.jogador.getInventario().adicionarItem(cafe);
            System.out.println("- Café Forte (x1)");

        } else {
            System.out.println("Você deixa a mochila intacta.");
        }
    }

    private void explorarBlocoC() throws Exception {
        System.out.println("Você está no Bloco C, onde tudo começou.");
        System.out.println("O corredor está silencioso. Parece seguro por enquanto.");
        // Este local pode ter um evento de encontrar um "Kit de Primeiros Socorros"
        System.out.println("Você vê um 'Kit de Primeiros Socorros' na parede da sala dos professores!");
        System.out.println("1. Pegar o Kit");
        System.out.println("2. Deixar");

        int escolha = Teclado.getUmInt();
        if (escolha == 1) {
            System.out.println("Você pega o Kit. Isso será muito útil.");
            Item kit = new Item("Kit de Primeiros Socorros", "Recupera 75 HP", "CURA_HP", 1, 75);
            this.jogador.getInventario().adicionarItem(kit);
        }

        //ESSE EVENTO DO KIT DE PRIMEIROS SOCORROS É APENAS UM EXEMPLO! O GUERREIRO JÁ VEM COM UM ENTÃO NÃO SEI
        //SE É UMA BOA DEIXAR ISSO.
    }

    private void explorarH15() throws Exception {
        System.out.println("Este é o H-15. No centro da sala, o Comandante Alienígena MATHEUS NOITES coordena as tropas.");
        System.out.println("Ele te vê e saca sua arma. Esta é a batalha final!");

        Inimigo chefe = new Inimigo("Matheus Noites", 350, 60, 60, (short) 10);
        chefe.getInventario().adicionarItem(new Item("Chave da Nave", "Desativa o campo de força", "ITEM", 1, 0));

        iniciarBatalha(chefe);

        //FALTA FAZER O FIM DA HISTÓRIA E DAR UM USO PRO ITEM CHAVE DA NAVE!
        //Não consegui pensar em um final bom kkkkkkkkkkkkkkk
    }

    private void abrirInventario() throws Exception {
        System.out.println(this.jogador.getInventario().toString());
        System.out.print("Digite o nome do item que deseja usar (ou 'voltar'): ");

        String nomeItem = Teclado.getUmString();

        if (nomeItem.equalsIgnoreCase("voltar")) {
            return;
        }
        
        boolean sucesso = this.jogador.getInventario().usarItem(nomeItem, this.jogador);

        if (sucesso) {
            System.out.println(this.jogador.getNome() + " usou " + nomeItem + ".");
        } else {
            System.out.println("Não foi possível usar " + nomeItem + ".");
        }
    }

    private void iniciarBatalha(Inimigo inimigo) throws Exception {
        System.out.println("!!! BATALHA INICIADA: " + inimigo.getNome() + " apareceu! !!!");

        boolean jogadorFugiu = false;

        while (this.jogador.getPontosVida() > 0 && inimigo.getPontosVida() > 0) {
            System.out.println("\n[TURNO DE COMBATE]");
            System.out.printf("Sua Vida (HP): %d\n", this.jogador.getPontosVida());
            System.out.printf("Vida Inimigo (HP): %d\n", inimigo.getPontosVida());

            System.out.println("O que você deseja fazer?");
            System.out.println("1. Atacar");
            System.out.println("2. Usar Item (Inventário)");
            System.out.println("3. Tentar Fugir");
            System.out.print("Escolha: ");

            int escolha = 0;
            try {
                escolha = Teclado.getUmInt();
            } catch (Exception e) {
                System.err.println("Opção inválida.");
                continue;
            }

            switch (escolha) {
                case 1:
                    this.jogador.batalhar(inimigo);
                    break;
                case 2:
                    abrirInventario();
                    break;
                case 3:
                    System.out.println("Você tenta fugir...");
                    int chanceFuga = dado.nextInt(10) + 1;
                    if (chanceFuga > 5) {
                        System.out.println("Você conseguiu fugir da batalha!");
                        jogadorFugiu = true;
                    } else {
                        System.out.println("A fuga falhou! O inimigo ataca!");
                        int dadoInimigo = dado.nextInt(6) + 1;
                        int ataqueTotalInimigo = inimigo.getAtaque() + dadoInimigo;
                        if (ataqueTotalInimigo > this.jogador.getDefesa()) {
                            int danoJogador = ataqueTotalInimigo - this.jogador.getDefesa();
                            if (danoJogador <= 0) danoJogador = 1;
                            this.jogador.setPontosVida(this.jogador.getPontosVida() - danoJogador);
                            System.out.println("O inimigo te acertou e causou " + danoJogador + " de dano!");
                        } else {
                            System.out.println("O inimigo ataca, mas você se defende!");
                        }
                    }
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

            if (jogadorFugiu) {
                break;
            }
        }

        if (jogadorFugiu) {
            System.out.println("Você fugiu com sucesso!");
        }
        else if (this.jogador.getPontosVida() > 0) {
            System.out.println("Você derrotou o " + inimigo.getNome() + "!");

            Item itemDropado;
            int chance = dado.nextInt(100);

            if (chance < 40) {
                // 0-39 (40% de chance): Não dropa nada
                itemDropado = null;
            } else if (chance < 65) {
                // 40-64 (25% de chance): Drop - Buff de Defesa
                // (Valores de qtdEfeito são sugestões)
                itemDropado = new Item("Pedaço de armadura alienígena", "Aumenta a Defesa em 3", "BUFF_DEF", 1, 3);
            } else if (chance < 90) {
                // 65-89 (25% de chance): Drop - Cura
                itemDropado = new Item("Injeção alienígena", "Recupera 40 HP", "CURA_HP", 1, 40);
            } else {
                // 90-99 (10% de chance): Drop - Buff de Ataque (mais raro)
                itemDropado = new Item("Lâmina alienígena", "Aumenta o Ataque em 7", "BUFF_ATK", 1, 7);
            }

            // Processa o resultado do drop
            if (itemDropado != null) {
                System.out.println("O inimigo deixou cair: " + itemDropado.getNome() + "!");

                this.jogador.getInventario().adicionarItem(itemDropado);
                System.out.println(itemDropado.getNome() + " foi adicionado ao seu inventário.");

            } else {
                System.out.println("O inimigo não deixou nada para trás.");
            }

        } else {
            System.out.println("Você foi abatido...");
        }
    }
}