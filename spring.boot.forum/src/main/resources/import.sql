insert into usuario(id, nome, email, senha) values (1, 'Carlos', 'carlos@gmail.com', '$2a$10$baKdoPyUYqLpb9wMn6o3zuyjlk8KcCiBSCTKS/jwdwEpq7ARhmk76');
insert into usuario(id, nome, email, senha) values (2, 'José', 'jose@gmail.com', '$2a$10$baKdoPyUYqLpb9wMn6o3zuyjlk8KcCiBSCTKS/jwdwEpq7ARhmk76');

insert into curso(id, nome, categoria) values (1, 'Spring Boot', 'Programacao');
insert into curso(id, nome, categoria) values (2, 'VueJS', 'Programacao');
insert into curso(id, nome, categoria) values (3, 'Python', 'Programacao');

insert into topico(id, titulo, curso_id) values (1, 'Bando de dados', 1);
insert into topico(id, titulo, curso_id) values (2, 'Consultas repository', 1);
insert into topico(id, titulo, curso_id) values (3, 'Rentorno de Paginação', 1);
insert into topico(id, titulo, curso_id) values (4, 'Informações Iniciais', 3);


insert into perfil(id, nome) values (1, 'aluno');
