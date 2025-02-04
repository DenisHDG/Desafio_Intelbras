# Desafio Intelbras - Aplicativo de Lista de Produtos

Este repositório contém o código-fonte do aplicativo desenvolvido para o desafio da **Intelbras**. O objetivo é disponibilizar uma lista de categorias de produtos, permitindo que o usuário realize buscas, visualize detalhes dos produtos e crie uma lista de desejos.

## 🚀 Tecnologias Utilizadas

- **Kotlin**
- **Jetpack Compose** (UI Declarativa)
- **MVVM (Model-View-ViewModel)** (Arquitetura)
- **Room** (Armazenamento local)
- **Koin** (Injeção de Dependência)
- **Retrofit** (Consumo de API)
- **Fake Store API** ([Documentação](https://fakestoreapi.com/docs))

## 🔬 Funcionalidades

- Tela de **Splash** de inicialização.
- Tela **Home** com:
  - Lista de **Categorias** de produtos.
  - Opção de **Desejos** para acessar produtos favoritados.
- Visualização de produtos por categoria com:
  - **Paginação** para otimizar a exibição.
  - Busca por produtos.
- Tela de **Detalhes do Produto**.
- **Favoritar Produtos**, com indicação visual na lista.
- Tela de **Lista de Desejos** com todos os produtos favoritados.

## 🔧 Como Rodar o Projeto

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/DenisHDG/Desafio_Intelbras.git
   ```
2. **Abra o projeto no Android Studio.**
3. **Sincronize o Gradle:**
   - Aguarde o download das dependências.
4. **Execute o projeto:**
   - Clique em "Run" ou pressione `Shift + F10`.

## 🌟 Escolhas Arquiteturais

- **MVVM:** Foi escolhida por facilitar a separação de responsabilidades, promovendo um código mais limpo e testável. O **MVI** foi descartado devido à complexidade adicional para o escopo do desafio.
- **Jetpack Compose:** Moderniza a construção da interface com uma abordagem declarativa.
- **Room:** Utilizado para armazenar localmente a lista de desejos, garantindo persistência dos dados mesmo offline.
- **Koin:** Simplifica a injeção de dependência, facilitando a gestão do ciclo de vida dos componentes.

## 🔗 Link do Repositório

[https://github.com/DenisHDG/Desafio_Intelbras](https://github.com/DenisHDG/Desafio_Intelbras)

---

Feito com ❤️ por **Denis Luiz Gonçalves**.

