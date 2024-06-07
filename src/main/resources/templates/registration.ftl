<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pagina di registrazione</title>
    <!-- Collegamento a Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
.container {
margin-top: 50px;
}
</style>

</head>
<body>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-body">
                    <h3 class="card-title text-center mb-4">Registrazione</h3>
                    <form id="registrationForm">
                        <div class="form-group">
                            <label for="userFirstName">Nome</label>
                            <input type="text" class="form-control" name="userFirstName" id="userFirstName" placeholder="Inserisci nome" required maxlength="255">
                        </div>
                        <div class="form-group">
                            <label for="userLastName">Cognome</label>
                            <input type="text" class="form-control" name="userLastName" id="userLastName" placeholder="Inserisci cognome" required maxlength="255">
                        </div>
                        <div class="form-group">
                            <label for="userAddress">Indirizzo</label>
                            <input type="text" class="form-control" name="userAddress" id="userAddress" placeholder="Inserisci indirizzo" required maxlength="255">
                        </div>
                        <div class="form-group">
                            <label for="userFiscalCode">Codice fiscale</label>
                            <input type="text" class="form-control" name="userFiscalCode" id="userFiscalCode" placeholder="Inserisci codice fiscale" required maxlength="16">
                        </div>

                        <div class="form-group">
                            <label for="inputEmail">Email</label>
                            <input type="email" class="form-control" name="userMail" id="userMail" placeholder="Inserisci l'email" required  maxlength="255">
                        </div>
                        <div class="form-group">
                            <label for="inputPassword">Password</label>
                            <input type="password" class="form-control" name="userPsd" id="userPsd" placeholder="Inserisci la password" required  maxlength="50">
                        </div>
                        <button type="submit" class="btn btn-primary btn-block">Registrati</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script>
        $(document).ready(function() {
            $('#registrationForm').submit(function(e) {
                e.preventDefault();

                var userFirstName = $('#userFirstName').val();
                var userLastName = $('#userLastName').val();
                var userMail = $('#userMail').val();
                var userPsd = $('#userPsd').val();
                var userAddress = $('#userAddress').val();
                var userFiscalCode = $('#userFiscalCode').val();

                var userData = {
                    "userFirstName": userFirstName,
                    "userLastName": userLastName,
                    "userMail": userMail,
                    "userPsd": userPsd,
                    "userAddress": userAddress,
                    "userFiscalCode": userFiscalCode
                };

                $.ajax({
                    type: "POST",
                    contentType: "application/json",
                    url: "/user/add",
                    data: JSON.stringify(userData),
                    dataType: 'json',
                    success: function(data) {
                        alert("Utente registrato con successo!");
                    },
                    error: function(xhr, textStatus, errorThrown) {
                        alert("Errore durante la registrazione: " + xhr.responseText);
                    }
                });
            });
        });
    </script>
</body>
</html>
