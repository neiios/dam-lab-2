CREATE TABLE
    IF NOT EXISTS place (
        id SERIAL PRIMARY KEY,
        name VARCHAR(1024) NOT NULL,
        address VARCHAR(1024) NOT NULL,
        latitude DOUBLE PRECISION NOT NULL,
        longitude DOUBLE PRECISION NOT NULL,
        description TEXT,
        image VARCHAR(1024),
        type INT,
        created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
        updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
    );

INSERT INTO
    place (
        name,
        address,
        latitude,
        longitude,
        description,
        image,
        type
    )
VALUES
    (
        'Torre de Belém',
        'Av. Brasília, 1400-038 Lisboa, Portugal',
        38.6916,
        -9.216,
        'A fortified tower located in the parish of Belém, that is a UNESCO World Heritage Site.',
        'https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/Torre_Bel%C3%A9m_April_2009-4a.jpg/628px-Torre_Bel%C3%A9m_April_2009-4a.jpg',
        1
    ),
    (
        'Mosteiro dos Jerónimos',
        'Praça do Império 1400-206 Lisboa, Portugal',
        38.6977,
        -9.2064,
        'A former monastery of the Order of Saint Jerome near the Tagus river in the parish of Belém.',
        'https://upload.wikimedia.org/wikipedia/commons/thumb/4/45/Mosteiro_dos_Jeronimos_-_Left_Wing.jpg/265px-Mosteiro_dos_Jeronimos_-_Left_Wing.jpg',
        1
    ),
    (
        'Castelo de S. Jorge',
        'R. de Santa Cruz do Castelo, 1100-129 Lisboa, Portugal',
        38.7139,
        -9.1335,
        'A historic castle in the Portuguese capital of Lisbon, located on a commanding hilltop.',
        'https://upload.wikimedia.org/wikipedia/commons/thumb/1/17/Castelo_de_S%C3%A3o_Jorge_%2810251035013%29.jpg/300px-Castelo_de_S%C3%A3o_Jorge_%2810251035013%29.jpg',
        2
    ),
    (
        'Praça do Comércio',
        'Praça do Comércio, 1100-148 Lisboa, Portugal',
        38.7075,
        -9.1364,
        'A large, harbor-facing square in Lisbon and one of the largest squares in Europe.',
        'https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/Arco_Triunfal_da_Rua_Augusta%2C_Plaza_del_Comercio%2C_Lisboa%2C_Portugal%2C_2012-05-12%2C_DD_02.JPG/1920px-Arco_Triunfal_da_Rua_Augusta%2C_Plaza_del_Comercio%2C_Lisboa%2C_Portugal%2C_2012-05-12%2C_DD_02.JPG',
        3
    ),
    (
        'Oceanário de Lisboa',
        'Esplanada Dom Carlos I s/nº, 1990-005 Lisboa, Portugal',
        38.7636,
        -9.0932,
        'One of the largest indoor aquariums in Europe, located in the Parque das Nações.',
        'https://upload.wikimedia.org/wikipedia/commons/thumb/0/0b/Lisboa-Oceanario.jpg/300px-Lisboa-Oceanario.jpg',
        4
    ),
    (
        'Museu Nacional do Azulejo',
        'R. Me. Deus 4, 1900-312 Lisboa, Portugal',
        38.7165,
        -9.1255,
        'A national museum dedicated to the azulejo (ceramic tile), housed in the former Convent of Madre de Deus.',
        'https://upload.wikimedia.org/wikipedia/commons/thumb/f/f4/Igreja_do_Convento_da_Madre_de_Deus%2C_Lisboa_%28Portugal%29.jpg/300px-Igreja_do_Convento_da_Madre_de_Deus%2C_Lisboa_%28Portugal%29.jpg',
        5
    );
