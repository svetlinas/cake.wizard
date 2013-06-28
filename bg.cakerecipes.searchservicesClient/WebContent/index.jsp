<%@page contentType="text/html" pageEncoding="windows-1251"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link href="style/style.css" rel="stylesheet" type="text/css" />
        <link href="style/jquery-ui.css" rel="stylesheet" type="text/css" />
        <script src="jquery/jquery-1.9.1.min.js"></script>
        <script src="jquery/jquery-ui.min.js"></script>
        <script src="jslib/contentManage.js"></script>
        <script src="jslib/spellchecker.js"></script>
        <script>
            $('document').ready(function(){
                var source = $.get("jslib/spellchecker-source.txt");
                setTimeout(function(){
                  speller.train(source.responseText)
                }, 200);

                $("#wizardWords").autocomplete({
                    source: function( request, response ) {
                        var list = [];
                        var results = [];
                        var query = $("#wizardWords").val();
                        var idx = query.lastIndexOf(" ");
                        if (idx > -1) {
                            var word = query.substr(idx + 1);
                            if (word.length > 4) {
                                results = speller.correct(word);
                            }
                        } else {
                            results = speller.correct(query); 
                        }

                        for (var i in results) { 
                            list.push(query.substr(0, idx + 1) + results[i])
                        }

                        if (list.length == 0) {
                            list.push(query);
                        }
                        response(list.reverse());
                    },
                    minLength: 4,
                    select: function( event, ui ) { return false; }
                });

                $('#wizardSearch').click(function(){
                    var _words = $('#wizardWords').val();

                    request = {
                        words:_words
                    };
                    
                    $.fn.load(request,'<%=request.getContextPath()%>/TestServlet');
                    return false;
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
                    <a href="" class="menuItem">CATALOG</a>
                    <a href="" class="menuItem selected" style="font-style:italic;">WIZARD</a>
                    <a href="" class="menuItem">H-MADE</a>
                    <a href="" class="menuItem">ABOUT</a>
                    <a href="" class="menuItem">HELP</a>

                </div>
            </div>

            <!-- CONTENT -->

            <fieldset id="cakeWizard">
                <!-- legend>Search for all of your favourite cakes</legend>
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
                </div> -->
                
                
                <form id="searchForm">
                	<input id="wizardWords" type="text" size="40" value="" />
                	<input id="wizardSearch" type="submit" value="SEARCH" class="submit" />
                </form>
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