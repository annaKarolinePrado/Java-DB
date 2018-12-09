CREATE DATABASE boutique;

CREATE TABLE empresa(
	id INT NOT NULL,
    nome_fantasia VARCHAR(50) NOT NULL,
    razao_social VARCHAR(50) NOT NULL,
    inscricao_municipal INT NOT NULL,
    inscricao_estadual INT NOT NULL,
    estado CHAR(2),
    cidade VARCHAR(50),
    regim_tributario VARCHAR(50),
    cnpj VARCHAR(50) NOT NULL,
    PRIMARY KEY(id)
)ENGINE = InnoDB;

CREATE TABLE cliente(
	id INT NOT NULL,
    nome VARCHAR(50) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    sexo BOOLEAN,
    dt_nasc VARCHAR(10),
    telefone VARCHAR(15),
    email VARCHAR(50),
    endereco VARCHAR(50),
    status BOOLEAN,
    PRIMARY KEY(id)
)ENGINE = InnoDB;

CREATE TABLE funcionario(
	id INT NOT NULL,
    nome VARCHAR(50) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    sexo BOOLEAN,
    dt_nasc VARCHAR(10) NOT NULL,
    telefone VARCHAR(15),
    email VARCHAR(50),
    endereco VARCHAR(50) NOT NULL,
    funcao VARCHAR(50),
    status BOOLEAN,
    PRIMARY KEY(id)
)ENGINE = InnoDB;

CREATE TABLE dependente(
	id INT NOT NULL,
    nome VARCHAR(50) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    sexo BOOLEAN,
    dt_nasc VARCHAR(10) NOT NULL,    
    status BOOLEAN,
    funcionario IN NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT FK_dependente_funcionario FOREIGN KEY(dependente) 
    REFERENCES funcionario(id)
)ENGINE = InnoDB;

CREATE TABLE categoria(
	id INT NOT NULL,
    descricao VARCHAR(50) NOT NULL,    
    status BOOLEAN,
    PRIMARY KEY(id)
)ENGINE = InnoDB;

CREATE TABLE marca(
	id INT NOT NULL,
    descricao VARCHAR(50) NOT NULL,  
    fornecedor INT NOT NULL,
    status BOOLEAN,
    PRIMARY KEY(id)
)ENGINE = InnoDB;

CREATE TABLE imposto(
	id INT NOT NULL,
    pis VARCHAR(50) NOT NULL,  
    cofins VARCHAR(50) NOT NULL,
    icms VARCHAR(50) NOT NULL,
    PRIMARY KEY(id)
)ENGINE = InnoDB;

CREATE TABLE salario(
	id INT NOT NULL,
    dt_salario DATE NOT NULL,  
    valor_bruto DOUBLE,
    descontos DOUBLE,
    valor_liquido DOUBLE NOT NULL,
    funcionario INT NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT FK_salario_funcionario FOREIGN KEY(funcionario) REFERENCES funcionario(id)
)ENGINE = InnoDB;

CREATE TABLE fornecedor(
	id INT NOT NULL,
    razao_social VARCHAR(50) NOT NULL,  
    representante INT NOT NULL,
    cnpj VARCHAR(50),
    marca INT NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT FK_fornecedor_marca FOREIGN KEY(marca) REFERENCES marca(id)
)ENGINE = InnoDB;

CREATE TABLE venda(
	id INT NOT NULL,
    cliente INT NOT NULL,  
    funcionario INT NOT NULL,
    quantidade INT NOT NULL,
    valor DECIMAL(10,2) NOT NULL,
    data  DATE NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT FK_venda_cliene FOREIGN KEY(cliente) REFERENCES cliente(id),
    CONSTRAINT FK_venda_funcionario FOREIGN KEY(funcionario) REFERENCES funcionario(id)
)ENGINE = InnoDB;

CREATE TABLE produto(
	id INT NOT NULL,
    descricao VARCHAR(50) NOT NULL,  
    tamanho INT NOT NULL,
    cor VARCHAR(50),
    quantidade INT NOT NULL,
    categoria INT NOT NULL,
    marca INT NOT NULL,
    colecao VARCHAR(50),
    valor_custo DECIMAL(10,2) NOT NULL,
    valor_venda DECIMAL(10,2) NOT NULL,
    lote VARCHAR(50),
    tributo VARCHAR(50),
    imposto INT NOT NULL,
    fornecedor INT NOT NULL,
    status BOOLEAN,
    PRIMARY KEY(id),
    CONSTRAINT FK_produto_categoria FOREIGN KEY(categoria) REFERENCES categoria(id),
    CONSTRAINT FK_produto_marca FOREIGN KEY(marca) REFERENCES marca(id),
    CONSTRAINT FK_produto_imposto FOREIGN KEY(imposto) REFERENCES imposto(id),
    CONSTRAINT FK_produto_fornecedor FOREIGN KEY(fornecedor) REFERENCES fornecedor(id)
)ENGINE = InnoDB;

CREATE TABLE usuario(
	id INT NOT NULL,
    login VARCHAR(50) NOT NULL,  
    senha VARCHAR(150) NOT NULL,
    nome VARCHAR(50) NOT NULL,
    PRIMARY KEY(id)
)ENGINE = InnoDB;

CREATE TABLE log(
	id INT NOT NULL,
    nome_tabela VARCHAR(50) NOT NULL, 
    id_tabela INT NOT NULL, 
    tipo_modificacao INT NOT NULL,
    data_alteracao DATE NOT NULL,
    usuario INT NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT FK_log_usario FOREIGN KEY(usuario) REFERENCES usuario(id)
)ENGINE = InnoDB; 