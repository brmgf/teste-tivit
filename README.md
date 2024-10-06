# Sistema de votação 📫

O sistema foi desenvolvido em Java utilizando o banco de dados MySql e tem como objetivo registrar votos de associados em pautas através de sessões de votação. 

## Endpoints
Abaixo, será detalhado os endpoints disponíveis, ou se preferir, pode importar o [arquivo](https://drive.google.com/drive/folders/1KAGq9Iiyoh21pwqvnqbbDJJh73P3XoMh?usp=sharing) diretamente em seu Postman.

## Listar associados
Retorna a lista de associados cadastrados: 

**GET/** https://sistema-votacao-da7ecc72c39c.herokuapp.com/associados

## Cadastrar associado
Cadastra associado, sendo obrigatório informar um nome:

**POST/** https://sistema-votacao-da7ecc72c39c.herokuapp.com/associados

**body:** 
{
    "nome": "Roberto Martins"
}

## Listar pautas
Retorna a lista de pautas para serem votadas: 

**GET/** https://sistema-votacao-da7ecc72c39c.herokuapp.com/pautas

## Cadastrar pauta
Cadastra uma pauta, sendo obrigatório informar uma descrição:

**POST/** https://sistema-votacao-da7ecc72c39c.herokuapp.com/pautas

**body:** 
{
    "descricao": "Instalação de corrimão nas escadarias"
}

## Listar sessões abertas
Retorna a lista de sessões abertas: 

**GET/** https://sistema-votacao-da7ecc72c39c.herokuapp.com/sessoes

## Abrir sessão de votação
É obrigatório informar uma pauta, sendo possível abrir uma nova sessão apenas para pautas que ainda não possuem sessões abertas. 
Não é obrigatório informar o fim da sessão, caso não seja informado, a sessão terá duração de 1 minuto. O formato da data e hora fim deverá ser dd/MM/aaaa HH:mm:

**POST/** https://sistema-votacao-da7ecc72c39c.herokuapp.com/sessoes

**body:** 
{
    "pautaId": 4,
    "fim": "10/10/2024 20:00"
}

## Votar
Uma votação é feita dentro de uma sessão que está atrelada a uma pauta. 
Cada associado poderá votar em uma pauta apenas uma vez, independente da sessão que votou.
Ao votar, é obrigatório informar o associado e o tipo de voto, sendo as opções disponíveis 'Sim' ou 'Não'.

**POST/** https://sistema-votacao-da7ecc72c39c.herokuapp.com/sessoes/{idSessao}/votos

**body:** 
{
    "associadoId": 4,
    "tipoVoto": "Não"
}

## Consultar resultados
Retorna o resultado das votações por pauta:

**GET/** https://sistema-votacao-da7ecc72c39c.herokuapp.com/pautas/{idPauta}/votos
