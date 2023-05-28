<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Sales Agent Page</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="ASSETS2/favicon.ico" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="CSS3/styles.css" rel="stylesheet" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        
    </head>
    <body>
        <!-- Responsive navbar-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="#">Sales Agent</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="test2.jsp">Home</a></li>
                        <li class="nav-item"><a class="nav-link" href="orderViewSA">All orders</a></li>
                        
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Dropdown</a>
                            <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="viewBrand?action=all">Brands</a></li>
                                <li><a class="dropdown-item" href="ViewCategory?action=all">Categories</a></li>
                                <li><hr class="dropdown-divider" /></li>
                                <li><a class="dropdown-item" href="ProductView?action=SAView">Inventory</a></li>
                            </ul>
                        </li>
                        <li class="nav-item"><a class="nav-link" href="SA_view?action=viewRequests">Requests</a></li>
                        <li class="nav-item"><a class="nav-link" href="Logout">Logout</a></li>
                    </ul>
                </div>
            </div>
        </nav>