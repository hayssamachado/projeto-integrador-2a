# Projeto Integrador 2A
An�lise e Desenvolvimento de Sistemas - PUC-GO

## Tema:
Educa��o para as rela��es �tnico-raciais e cultura afro-brasileira, africana e ind�gena.

## Descri��o:
Desenvolvimento, projeto e implementa��o de um sistema de cadastro de questões sobre este tema.

## Instru��es:
* Rodar os scrips abaixo para cria��o de banco e tabelas.
* Utilizar preferencialmente versões do java superior a 1.8.
* Atentar-se se a lib do driver postgresql est� registrada no build path.

### Scripts

```sql

#Cria tabela usuarios
CREATE TABLE public.usuarios
(
    cpf  varchar NOT NULL,
    nome varchar NOT NULL,
    CONSTRAINT usuarios_pk PRIMARY KEY (cpf)
);

#Cria tabela perguntas
CREATE TABLE public.perguntas
(
    id        serial4 NOT NULL,
    descricao varchar NOT NULL,
    gabarito  varchar NOT NULL,
    CONSTRAINT perguntas_pk PRIMARY KEY (id)
);
```

## Melhorias Previstas
* Associar perguntas aos usu�rios registrados e "logados";
* Criar tipos de perguntas (Atualmente s�o aceitas apenas perguntas argumentativas);
* Criar tipos de respostas;
* Melhorar intera��o via menu.

## Contribui��es
Melhorias s�o bem vindas, s� criar o pull request que com tempo ser� avaliado.

## License
[MIT](https://choosealicense.com/licenses/mit/)