# Projeto Integrador 2A
Análise e Desenvolvimento de Sistemas - PUC-GO

## Tema:
Educação para as relações Étnico-raciais e cultura afro-brasileira, africana e indígena.

## Descrição:
Desenvolvimento, projeto e implementação de um sistema de cadastro de questÃµes sobre este tema.

## Instruções:
* Rodar os scrips abaixo para criação de banco e tabelas.
* Utilizar preferencialmente versÃµes do java superior a 1.8.
* Atentar-se se a lib do driver postgresql está registrada no build path.

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
* Associar perguntas aos usuários registrados e "logados";
* Criar tipos de perguntas (Atualmente são aceitas apenas perguntas argumentativas);
* Criar tipos de respostas;
* Melhorar interação via menu.

## Contribuições
Melhorias são bem vindas, só criar o pull request que com tempo será avaliado.

## License
[MIT](https://choosealicense.com/licenses/mit/)