<div class="container">
  <h2>rechercher un contact</h2>
  <form action='/api/search-contacts' method='get'>
 
    <table class='table table-hover table-responsive table-bordered'>
 
        <tr>
            <td><b>Prénom</b></td> 
            <td><input type='text' name='firstName' class='form-control'/></td>
        
            <td><b>Nom</b></td>
            <td><input type='text' name='lastName' class='form-control' /></td>
       
            <td><b>Email</b></td>
            <td><input type='text' name='email'  class='form-control'/></td> 
        </tr>
 
        <tr>
            <td><b>Promotion</b></td>
            <td><input type='text' name='graduationYear'class='form-control'/></td>
        
            <td><b>Poste</b></td>
            <td><input type='text' name='companyPosition' class='form-control'/></td>
            
        </tr>
 		<input type = "submit" value = "Submit" />
    </table>
</form>
 </div>