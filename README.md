# 🚛 Heavy Service

Aplicação desenvolvida para a disciplina de **Laboratório de Desenvolvimento para Dispositivos Móveis (LDDM)** utilizando **Kotlin**, **Ktor** e **Jetpack Compose**.

O projeto simula um sistema de gerenciamento de **Ordens de Serviço para caminhões**, permitindo visualizar, cadastrar e consultar ordens através de uma aplicação Android integrada a um backend REST.

---

# 📋 Objetivo

Desenvolver uma aplicação completa contendo um backend e um aplicativo Android nativo, realizando a comunicação entre frontend e backend através de requisições HTTP.

O sistema permite o gerenciamento de ordens de serviço de veículos pesados, simulando o fluxo básico de uma oficina especializada em caminhões.

---

# 🛠 Tecnologias Utilizadas

## Backend

- Kotlin
- Ktor Server
- Netty
- Kotlinx Serialization

## Aplicativo Android

- Kotlin
- Jetpack Compose
- Material Design 3
- Navigation Compose
- ViewModel
- StateFlow
- Ktor Client

## Arquitetura

- MVVM (Model - View - ViewModel)
- API REST
- Gerenciamento de estado com StateFlow
- Comunicação via JSON

---

# 📂 Estrutura do Projeto

```text
heavy-service/
│
├── composeApp/
│   ├── navigation/
│   ├── screen/
│   ├── theme/
│   └── MainActivity.kt
│
├── shared/
│   ├── model/
│   ├── service/
│   └── viewmodel/
│
└── server/
    ├── routes/
    └── Application.kt
```

---

# 🚀 Funcionalidades

## Aplicativo Android

- Visualização de ordens de serviço cadastradas
- Cadastro de novas ordens
- Tela de detalhes da ordem
- Atualização automática da listagem
- Feedback visual para o usuário
- Interface moderna construída com Jetpack Compose

## Backend

- Endpoint GET para consulta das ordens
- Endpoint POST para cadastro de novas ordens
- Respostas em formato JSON
- Armazenamento em memória utilizando MutableList

---

# 🔗 Endpoints

## Listar Ordens

```http
GET /ordens
```

## Cadastrar Ordem

```http
POST /ordens
```

### Exemplo de JSON

```json
{
  "id": 4,
  "cliente": "Transportadora Horizonte",
  "marca": "DAF",
  "modelo": "XF 480",
  "ano": 2024,
  "quilometragem": 45000,
  "solicitacao": "Falha no sistema de suspensão",
  "status": "Em análise",
  "dataAbertura": "2026-05-27"
}
```

---

# ▶️ Como Executar

## Executar o Backend

No terminal, execute:

```bash
./gradlew :server:run
```

O servidor ficará disponível em:

```text
http://127.0.0.1:8080
```

---

## Executar o Aplicativo Android

Abra o projeto no Android Studio e execute o módulo:

```text
composeApp
```

utilizando um dispositivo físico ou emulador Android.

---

# 🎥 Vídeo Demonstrativo

Link do vídeo:

```text
https://youtu.be/R0FEjN3NeGA
```

---

# 👨‍💻 Autor

**Lucas Miura**

Projeto desenvolvido para fins acadêmicos na disciplina de **Laboratório de Desenvolvimento para Dispositivos Móveis (LDDM)**, utilizando o projeto base disponibilizado pelo professor.
