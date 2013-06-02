<%@page contentType="text/html" pageEncoding="windows-1251"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link href="style/style.css" rel="stylesheet" type="text/css" />
        <script src="jquery/jquery-1.4.2.min.js"></script>
        <script src="jslib/contentManage.js"></script>
        <script src="jslib/global.js"></script>
        <script>
            $('document').ready(function(){

                $('#wizardSearch').click(function(){
                    
                    var _contents = new Array();
                        $('#cakeContent input:checked').each(function(){
                            _contents = _contents.concat($(this).val());
                        });

                    var _occasion = $('#cakeOccasion input:checked').val();

                    request = {
                        content:_contents,
                        occasion:_occasion
                    };
                    
                    $.fn.load(request,'<%=request.getContextPath()%>/TestServlet');
                    
                    $('#loadingDiv')
                    .hide()  // hide it initially
                    .ajaxStart(function() {
                        $(this).show();
                    })
                    .ajaxStop(function() {
                        $(this).hide();
                    })
                ;
                });
            });
        </script>
    </head>

    <body>
        <div id="wrapper">

            <!-- HEADER -->

            <div id="header">
                <div id="searchBox">
                    <form action="http://www.google.com/custom" method="GET">
                        <label>SEARCH:</label>
                        <input class="textField" type="text" name="q" />
                        <input class="submit" type="submit" value="&nbsp;" />
                    </form>
                </div>
                <div id="menu">

                    <a href="" class="menuItem left">HOME</a>
                    <a href="ind.html" class="menuItem">CATALOG</a>
                    <a href="" class="menuItem selected" style="font-style:italic;">WIZARD</a>
                    <a href="cakeWizard.html" class="menuItem">H-MADE</a>
                    <a href="" class="menuItem">ABOUT</a>
                    <a href="" class="menuItem">HELP</a>

                </div>
            </div>

            <!-- CONTENT -->

            <fieldset id="cakeWizard">
                <legend>Search for all of your favourite cakes</legend>
                <div id="cakeContent" class="field" style="float:right;">
                    <label></label>
                    <div class="checkLabel">
                        <input type="checkbox" name="cakeContent" value="FRUITY"/>FRUITY
                    </div>
                    <div class="checkLabel">
                        <input type="checkbox" name="cakeContent" value="CHOCOLATE"/>CHOCOLATE
                    </div>
                    <div class="checkLabel">
                        <input type="checkbox" name="cakeContent" value="CARAMEL"/>CARAMEL
                    </div>
                    <div class="checkLabel">

                        <input type="checkbox" name="cakeContent" value="CREAM"/>CREAM
                    </div>
                    <div class="checkLabel">
                        <input type="checkbox" name="cakeContent" value="LIGHT"/>LIGHT
                    </div>
                    <div class="checkLabel">
                        <input type="checkbox" name="cakeContent" value="VEGETARIAN"/>VEGETARIAN
                    </div>
                    <div class="checkLabel">
                        <input type="checkbox" name="cakeContent" value="BISCUIT"/>BISCUIT
                    </div>
                </div>
                <div id="cakeOccasion" class="field">
                    <label>Occasions</label>
                    <div class="checkLabel">
                        <input type="radio" name="case" value="BIRTHDAY"/>BIRTHDAY
                    </div>
                    <div class="checkLabel">
                        <input type="radio" name="case" value="WEDDING"/>WEDDING
                    </div>
                    <div class="checkLabel">
                        <input type="radio" name="case" value="SURPRISE"/>SURPRISE
                    </div>
                    <div class="checkLabel">

                        <input type="radio" name="case" value="" checked/>all
                    </div>
                </div>
                <input id="wizardSearch" type="submit" value="SEARCH" class="submit" />
            </fieldset>
            
			<div id="loadingDiv">
            </div>
            <div id="content">
            </div>
            <div id="pagerContent"></div>

            <!-- FOOTER -->

            <div id="footer">
                <div id="copyright">Copyright 2013</div>
                <div id="footerMenu">
                    <a href="">HOME</a>
                    <a href="">CATALOG</a>
                    <a href="">WIZARD</a>

                    <a href="">H-MADE</a>
                    <a href="">ABOUT</a>
                    <a href="" class="last">HELP</a>
                </div>
            </div>
        </div>
    </body>
</html>
