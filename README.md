# Execicio2-PSA
Exercicio 2 da disciplina de programação de software aplicado

testes:
POST /auth/login
{
  "username": "admin",
  "password": "admin123"
}

GET /api/admin
Authorization: Bearer <token-do-admin>

resposta esperada: Hello, admin!

Se você acessar /api/hello ou /api/admin sem Authorization: Bearer ..., receberá:

401 Unauthorized (não autenticado), ou
403 Forbidden (se autenticado, mas sem permissão)
