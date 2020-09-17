<?php 


//Como obtner el usuario y password para autenticar
if(!array_key_exists('HTTP_X_TOKEN', $_SERVER)){
    echo "Ujule desde el principio estamos mal";
    die;
}

$url = 'htttp://localhost:8001';
$ch = curl_init( $url);
curl_setopt(
    $ch,
    CURLOPT_HTTPHEADER,
    [
        "X-Token: {$_SERVER['HTTP_X_TOKEN']}"
    ]
);
curl_setopt(

    $ch,
    CURLOPT_RETURNTRANSFER,
    true
);
$ret = curl_exec($ch);

if($ret == 'true'){
    echo "No pudo ser autenticado";
    die;
}



// Definiendo los recursos disponibles
$allowedResourceTypes = [
    'books',
    'authors',
    'genres',
];

// Validamos que el recurso esté dispibible
$resoruceType = $_GET['resource_type'];

if(!in_array($resoruceType, $allowedResourceTypes)){
    die;
}

// Definiendo los recursos
$books = [
    1 => [
        'Titulo' => 'Lo que el viento se llevo',
        'id_autor' => 2,
        'id_genero' => 2,
    ],
    2 => [
        'Titulo' => 'La ileada',
        'id_autor' => 1,
        'id_genero' => 1,
    ], 
    3 => [
        'Titulo' => 'La odisea',
        'id_autor' => 3,
        'id_genero' => 3,
    ],
];



header( 'Content-Type : application/json');

// Levantamos el id del recurso buscado 
$resource_id = array_key_exists('resource_id', $_GET) ? $_GET['resource_id']: '';
// Generamos la respuesta asumiendo que el pedido es correcto.
switch(strtoupper($_SERVER['REQUEST_METHOD'])){

    case 'GET':
        if(empty($resource_id)){
            echo json_encode($books);
        } else{
            if(array_key_exists($resource_id, $books)){
                echo json_encode($books[$resource_id]);
            }
        }
        break;

    case 'POST':
        $json = file_get_contents('php://input');

        $books[] = json_decode($json, true);

        //echo array_keys($books)[count($books) - 1];   
        echo json_encode($books);   
        break;

    case 'PUT':
        //Validamos que el recurso buscado sí exista
        if(!empty($resource_id)  && array_key_exists($resource_id, $books)){
            $json = file_get_contents('php://input');

            $books[$resource_id] = json_decode($json, true);

            //Regresamos toda la colección modificada en formato json
            echo json_encode($books);
        }
        break;
    case 'DELETE':

        //Validamos que el recurso realmente exista
        if(!empty($resource_id)  && array_key_exists($resource_id, $books)){
            unset($books[$resource_id]);

            echo json_encode($books);
        }
        break;
}