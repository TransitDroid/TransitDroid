<?php
if ($_GET['randomId'] != "SBEQZmkFjJKE_S1v9McBMiIUC5ChXGkyuPHxSMVRCKs7PsC75jbdnAZd92a2M__R") {
    echo "Access Denied";
    exit();
}

// display the HTML code:
echo stripslashes($_POST['wproPreviewHTML']);

?>  
