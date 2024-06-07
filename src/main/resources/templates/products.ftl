<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista Prodotti</title>
    <!-- Collegamento a Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1 class="mt-5 mb-4">Lista Prodotti</h1>
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <div class="card">
                    <div class="card-body">
                        <div class="list-group">
                            <#if products?has_content>
                                <#list products as product>
                                    <a href="#" class="list-group-item list-group-item-action">
                                        <h5 class="mb-1">${product.productName}</h5>
                                        <p class="mb-1">Prezzo: ${product.productPrice}</p>
                                    </a>
                                </#list>
                            <#else>
                                <p class="text-muted">Nessun prodotto disponibile al momento.</p>
                            </#if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Collegamento a Bootstrap JavaScript (opzionale) -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
