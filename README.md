
## Teste para BackEnd para UOL HOST(API)
Desafio criado no Padrão Rest.

## Link Hospedagem da Api

https://api-uol-desafio.hitalosirianodev.com.br/

## Link desafio

https://github.com/uolhost/test-backEnd-Java
## Documentação da API

#### Retorna todos os jogadores

```http
  GET /api/view/player
```



#### Cadastra um Jogador

```http
  POST /api/player
```

````

{
    "name" : "exemplo",
    "email" : "exemplo@api.com",
    "fone" : "999999999",
    "grouphero" : "avengers"
}
````
ou

````

{
    "name" : "exemplo",
    "email" : "exemplo@api.com",
    "fone" : "999999999",
    "grouphero" : "justice league"
}
````

#### Editar um Jogador

```http
  PUT /api/update/player/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `UUID` |  2ec15cd7-8e40-44ea-a1a0-e3737b033158 

````

{
    "name" : "exemplo",
    "email" : "exemplo@api.com",
    "fone" : "999999999",
    "grouphero" : "avengers"
}
````
````

{
    "name" : "exemplo",
    "email" : "exemplo@api.com",
    "fone" : "999999999",
    "grouphero" : "justice league"
}
````


#### Deleta um jogador

```http
  DELETE /api/delete/player/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `UUID` |  2ec15cd7-8e40-44ea-a1a0-e3737b033158 





## Tecnologia utilizada


**Back-end:** Java 17, Jpa , h2 database , Spring boot.


## Arquitetura do Projeto

![App Screenshot](https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/arquitetura.png)
