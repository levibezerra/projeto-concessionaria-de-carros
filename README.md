# 🚗 Concessionária de Carros - Sistema de Vendas com Interface Swing

### Este é um sistema desktop de Concessionária de Carros desenvolvido em **Java** com **interface gráfica (Swing)**, Para disciplina de Banco de Dados 2. O sistema permite a **compra de carros** por clientes, além de um painel administrativo para **gerenciar e visualizar estoque, clientes e carros**.

# 📌 Funcionalidades

## 🛠️ Administrador

  - Cliente
    - Buscar
    - Listar
    - Atualizar
    - Deletar
  - Carro
    - Adicionar
    - Buscar
    - Listar
    - Atualizar
    - Deletar

## 👥 Cliente
- Cadastro e login de cliente
- Visualização de carros disponíveis por categoria (Popular, Esportivo)
- Compra de carros com forma de pagamento via PIX ou Cartão
- Visualização de dados pessoais

# 🧱 Tecnologias Utilizadas

- **Java** (Java 21+)
- **Swing** (interface gráfica)
- **JPA e Hibernate** (persistência de dados)
- **MySQL** (banco de dados relacional)
- **Maven** (gerenciamento de dependências)

# 🗂️ Estrutura do Projeto

    📁 src
        📁main
            📁java
                📁org.example
                    📁abstract_factory - Padrão para criar os carros populares e esportivos.
                    📁app - Onde está o código principal do projeto, Main.
                    📁config - Configurar e gerenciar a conexão com o banco de dados usando JPA. 
                    📁controller -  Camada de controle e ouvintes do Swing
                    📁dao - Acesso ao banco de dados (JPA/Hibernate)
                    📁dto - Transferência de dados entre camadas
                    📁entity - Entidades JPA (Cliente, Carro, Venda, etc.)
                    📁enums - Enums do sistema (Perfil, Status, TipoDeCarro, etc).
                    📁repository - Interface para criar carros do padrão abstract factory.
                    📁service - Faz a verificação dos dados para mandar para o dao.
                    📁view - Interface Swing onde estão as telas e ouvintes.
            📁resources
                📁META-INF - Onde está o arquivo persistence.xml que é responsável por configurar a unidade de persistência.
                📁util.img - Imagem da tela inicial do projeto.
        📁teste
# 📊 Banco de Dados

- Tabelas:
    - `clientes`
    - `usuarios`
    - `carros`
    - `estoque`
    - `vendas`
    - `pagamentos`
    - `carros_vendidos`
    - `administradores`

- Relacionamentos entre entidades com JPA (`@OneToOne`, `@ManyToOne`, etc.)
- Atualização automática do status de carros no estoque após venda

# ⚙️ Como Rodar o Projeto

1. **Clone o repositório**
   ```bash
   git clone https://github.com/seu-usuario/concessionaria-carros.git

2. **Configure o banco de dados MySQL**
    ```bash
    Crie um banco de dados com o nome concessionaria_db por exemplo
    Atualize o arquivo persistence.xml com as credenciais corretas

3. **Abra o projeto no IntelliJ ou Eclipse**
    ```bash
    Execute a classe Main.java