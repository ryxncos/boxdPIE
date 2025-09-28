**Segue abaixo a DML para inserir no SQL para a criação da tabela** </BR>

CREATE TABLE film ( <br>
    id INT AUTO_INCREMENT PRIMARY KEY, <br>
    title VARCHAR(255) NOT NULL, <br>
    year INT, <br>
    genre VARCHAR(100),<br>
    director VARCHAR(255),<br>
    synopsis TEXT;<br>
);
