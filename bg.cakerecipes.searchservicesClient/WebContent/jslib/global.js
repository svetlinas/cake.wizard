$('document').ready(function(){
    var interval = null;

    function slideShow(id ,width, pages, k, elementForDelete){
        var lenght = 0;
        var container = document.getElementById(id);
        var currentLeft = container.scrollLeft;
        if(k == 'b')currentLeft = container.scrollLeft = 800;

        if(interval != null)return;

        if(currentLeft == 0 && k == 'b')return;
        if(currentLeft >= pages*width && k == 'n')return;
        interval = setInterval(
            function(){
                var step = 100;
                var p;
                if(1 - lenght / width < 0.05)p = 0.05;
                else p = 1 - lenght / width;

                if(k == 'b')container.scrollLeft -= step*p;
                else container.scrollLeft += step*p;
                lenght += step*p;

                if(k == 'n' && container.scrollLeft >= currentLeft + width){
                    container.scrollLeft = currentLeft + width;
                    elementForDelete.parentNode.removeChild(elementForDelete);
                    container.scrollLeft = 0;
                    clearInterval(interval);
                    interval = null;
                }else if(k == 'b' && container.scrollLeft <= currentLeft - width){
                    container.scrollLeft = currentLeft - width;
                    elementForDelete.parentNode.removeChild(elementForDelete);
                    container.scrollLeft = 0;
                    clearInterval(interval);
                    interval = null;
                }
            }
            , 30);
    }

    function loadPage(pageNumber, direction){
        var container = _$('container');

        var pageItem = document.createElement('div');
        pageItem.className = 'pageItem';
        for(var i=(pageNumber-1)*4 ; i < pageNumber*4 && i < cake.length ; i++){
            cakeItem(pageItem, cake[i], i);
        }

        var elemForDel = container.getElementsByTagName('div')[0];

        switch(direction){
            case 'l':
                container.insertBefore(pageItem, elemForDel);
                slideShow('content',800,8,'b',elemForDel);
                break;
            case 'r':
                container.appendChild(pageItem);
                slideShow('content',800,8,'n',elemForDel);
                break;
            default:
                container.appendChild(pageItem);
        }
    }

    $.fn.addCake = function (pageNumber){
        var content = _$('content');
        if(_$('container')){
            content.removeChild(_$('container'));
        }

        var container = document.createElement('div');
        container.id = 'container';
        content.appendChild(container);

        if(cake.length == 0){
            var pageItem = document.createElement('div');
            pageItem.className = 'pageItem';
            var error = document.createElement('div');
            error.className = 'error';
            error.appendChild(document.createTextNode('Ууупс, няма резултати!'))
            pageItem.appendChild(error);
            container.appendChild(pageItem);
            _$('pager').parentNode.removeChild(_$('pager'));
            return;
        }

        var pages = cake.length/4;
        if(pages > parseInt(pages, 10)){
            pages = parseInt(pages, 10)+1;
        }

        var page = 1;
        if(pageNumber && pageNumber > 0 && pageNumber <= pages){
            page = pageNumber;
        }

        loadPage(page,'c');

        var p = new Pager(_$('pagerContainer'), pages);
        p.action = function(current, position){
            if(current==position){
            }else if(current<position)
                loadPage(position,'r');
            else
                loadPage(position,'l');
        }
        p.init(page);
    }

    function _$(id){
        return document.getElementById(id);
    }

    function cakeItem(container, theCake, i){
        var cakeItem = document.createElement('div');
        cakeItem.className = 'cakeItem' + ' ' + theCake[0];

        var photo = document.createElement('div');
        photo.className = 'photo';

        var img = document.createElement('img');
        img.src = theCake[1];

        var cakeContent = document.createElement('div');
        cakeContent.className = 'cakeContent';

        var cakeRealContent = document.createElement('div');
        cakeRealContent.id = theCake[0];
        cakeRealContent.className = 'cakeRealContent';

        var title = document.createElement('h4');
        title.appendChild(document.createTextNode(theCake[0]));
        title.className = 'cakeName';
        cakeRealContent.appendChild(title);

        var h4 = document.createElement('h4');
        h4.appendChild(document.createTextNode('Основно съдържание:'));
        cakeRealContent.appendChild(h4);
        cakeRealContent.appendChild(document.createTextNode(theCake[2]));

        var cakeBuyForm = buyForm(theCake[0], theCake[4], i);

        //price start
        var price = document.createElement('div');
        price.className = 'price';
        h4 = document.createElement('h4');
        h4.appendChild(document.createTextNode('Поръчай'));
        price.appendChild(h4);

        //little
        var realPriceL = sizePrice(theCake[4], 0);
        var priceRange = document.createElement('div');
        priceRange.className = 'priceRange';

        var priceSize = document.createElement('div');
        priceSize.className = 'priceSize';
        priceSize.appendChild(document.createTextNode('малка'));
        priceRange.appendChild(priceSize);

        var priceCost = document.createElement('div');
        priceCost.className = 'priceCost';
        priceCost.appendChild(document.createTextNode(realPriceL));
        priceRange.appendChild(priceCost);
        priceRange.appendChild(document.createTextNode('лв.'));
        price.appendChild(priceRange);

        priceRange.onclick = function(){
            cakeRealContent.style.display = 'none';
            priceSizeControl(cakeBuyForm, 0, theCake[4]);
            cakeBuyForm.className += ' ' + 'now';
        }

        //middle
        var realPriceM = sizePrice(theCake[4], 1);
        priceRange = document.createElement('div');
        priceRange.className = 'priceRange';

        priceSize = document.createElement('div');
        priceSize.className = 'priceSize';
        priceSize.appendChild(document.createTextNode('средна'));
        priceRange.appendChild(priceSize);

        priceCost = document.createElement('div');
        priceCost.className = 'priceCost';
        priceCost.appendChild(document.createTextNode(realPriceM));
        priceRange.appendChild(priceCost);
        priceRange.appendChild(document.createTextNode('лв.'));
        price.appendChild(priceRange);

        priceRange.onclick = function(){
            cakeRealContent.style.display = 'none';
            priceSizeControl(cakeBuyForm, 1, theCake[4]);
            cakeBuyForm.className += ' ' + 'now';
        }

        //big
        var realPriceB = theCake[4];
        priceRange = document.createElement('div');
        priceRange.className = 'priceRange';

        priceSize = document.createElement('div');
        priceSize.className = 'priceSize';
        priceSize.appendChild(document.createTextNode('голяма'));
        priceRange.appendChild(priceSize);

        priceCost = document.createElement('div');
        priceCost.className = 'priceCost';
        priceCost.appendChild(document.createTextNode(realPriceB));
        priceRange.appendChild(priceCost);
        priceRange.appendChild(document.createTextNode('лв.'));
        price.appendChild(priceRange);

        priceRange.onclick = function(){
            cakeRealContent.style.display = 'none';
            priceSizeControl(cakeBuyForm, 2, theCake[4]);
            cakeBuyForm.className += ' ' + 'now';
        }
        //price end

        photo.appendChild(img);
        cakeItem.appendChild(photo);
        cakeContent.appendChild(cakeRealContent);
        cakeContent.appendChild(cakeBuyForm);
        cakeItem.appendChild(cakeContent);
        cakeItem.appendChild(price);
        container.appendChild(cakeItem);
    }

    function buyForm(name, thePrice, cakeIndex){
        var form = document.createElement('form');
        form.className = 'buy';
        var h4 = document.createElement('h4');
        h4.appendChild(document.createTextNode('Поръчай'));
        form.appendChild(h4);

       
        checkLabel = document.createElement('div');
        checkLabel.className = 'checkLabel';
        label = document.createElement('label');
        label.appendChild(document.createTextNode('Количество'));
        checkLabel.appendChild(label);
        input = document.createElement('input');
        input.type = 'text';
        //input.name = 'count';
        input.className = 'count';
        input.value = '1';

        input.onkeydown = function(){
            var evt  = (evt) ? evt : ((event) ? event : null);
            var node = (evt.target) ? evt.target : ((evt.srcElement) ? evt.srcElement : null);
            if(evt.keyCode == 8 || evt.keyCode == 9 || evt.keyCode == 37 || evt.keyCode == 39)return true;
            if(evt.keyCode < 48 || evt.keyCode > 57)return false;
        }

        
        checkLabel.appendChild(input);
        var maxLength = document.createElement('span');
        maxLength.appendChild(document.createTextNode('максимум 99'));
        
        var field = document.createElement('div');
        field.className = 'field';
        var label = document.createElement('label');
        label.appendChild(document.createTextNode('Размер'));
        field.appendChild(label);

        var checkLabel = document.createElement('div');
        checkLabel.className = 'checkLabel';

        var option = document.createElement('option');
        option.value = 0;
        option.appendChild(document.createTextNode('малка'));
        select.appendChild(option);

        option = document.createElement('option');
        option.value = 1;
        option.appendChild(document.createTextNode('средна'));
        select.appendChild(option);

        option = document.createElement('option');
        option.value = 2;
        option.appendChild(document.createTextNode('голяма'));
        select.appendChild(option);
        field.appendChild(select);

        var optionlabel = document.createElement('label');
        field.appendChild(optionlabel);


       
        input = document.createElement('input');
        input.type = 'button';
        input.value = 'постави в количката';
        

        input = document.createElement('input');
        input.type = 'button';
        input.value = 'отказ';
        input.onclick = function(){
            form.className = form.className.split(' ')[0];
            document.getElementById(name).style.display = 'block';
        }
        buyButton.appendChild(input);

        form.appendChild(field);
        
        return form;
    }

    
    //pager
    var Pager = function(container, number){
        if(_$('pager')){
            container.removeChild(_$('pager'));
        }

        var pager = document.createElement('div');
        pager.id = 'pager';
        if(number <= 5){
            pager.style.width = number*30 + 'px';
        }else{
            pager.style.width = 9*30 + 'px';
        }


        this.action;
        this.container = container;
        this.number = number;

        this.events = function(){
            var nodes = pager.getElementsByTagName('div');
            var repage = this.repage;
            var action = this.action;

            var getPos = function(){
                for(var i=0 ; i < nodes.length ; i++){
                    if(nodes[i].className == 'selected'){
                        return parseInt(nodes[i].innerHTML);
                    }
                }
            }

            var number = this.number;

            if(number <= 5){
                for(var i=0 ; i < number ; i++){
                    nodes[i].onclick = function(){
                        repage(getPos(), parseInt(this.innerHTML, 10), action);
                    }
                }
                return;
            }

            nodes[0].onclick = function(){
                repage(getPos(), 1, action);
            }

            nodes[1].onclick = function(){
                var pos = getPos();
                if(pos <= 1)return;
                repage(pos, pos-1, action);
            }

            nodes[nodes.length-1].onclick = function(){
                repage(getPos(), number, action);
            }

            nodes[nodes.length-2].onclick = function(){
                var pos = getPos();
                if(pos >= number)return;
                repage(pos, pos+1, action);
            }

            for(var i=2 ; i < nodes.length-2 ; i++){
                nodes[i].onclick = function(){
                    repage(getPos(), parseInt(this.innerHTML), action);
                }
            }
        }

        this.repage = function(current, position, action){
            if(interval != null)return;
            var nodes = pager.getElementsByTagName('div');

            if(nodes.length <= 5){
                for(var i=0; i < nodes.length ; i++){
                    if(i == position-1)nodes[i].className = 'selected';
                    else nodes[i].className = '';
                    nodes[i].innerHTML = i+1;
                }
                action(current, position);
                return;
            }

            var num;
            if(position <= 3){
                num = 1;
            }else if(number - position < 2){
                num = number - 4;
            }else{
                num = position - 2;
            }

            for(var i=2; i < nodes.length-2 ; i++, num++){
                if(num == position)nodes[i].className = 'selected';
                else nodes[i].className = '';
                nodes[i].innerHTML = num;
            }

            if(this.number <= 5){
                nodes[0].className += ' disabled';
                nodes[1].className += ' disabled';
                nodes[nodes.length-2].className += ' disabled';
                nodes[nodes.length-1].className += ' disabled';
            }else if(position <= 3){
                if(position == 1){
                    nodes[1].className += ' disabled';
                }else{
                    nodes[1].className = nodes[1].className.split(' ')[0];
                }
                nodes[0].className += ' disabled';
                nodes[nodes.length-2].className = nodes[nodes.length-2].className.split(' ')[0];
                nodes[nodes.length-1].className = nodes[nodes.length-1].className.split(' ')[0];
            }else if(position >= number - 2){
                if(position == number){
                    nodes[nodes.length-2].className += ' disabled';
                }else{
                    nodes[nodes.length-2].className = nodes[nodes.length-2].className.split(' ')[0];
                }
                nodes[nodes.length-1].className += ' disabled';
                nodes[0].className = nodes[0].className.split(' ')[0];
                nodes[1].className = nodes[1].className.split(' ')[0];
            }else{
                nodes[0].className = nodes[0].className.split(' ')[0];
                nodes[1].className = nodes[1].className.split(' ')[0];
                nodes[nodes.length-2].className = nodes[nodes.length-2].className.split(' ')[0];
                nodes[nodes.length-1].className = nodes[nodes.length-1].className.split(' ')[0];
            }
            action(current, position);

        }

        this.init = function(pageNumber){
            if(this.number <= 5){
                for(var i=0 ; i < this.number ; i++){
                    var node = document.createElement('div');
                    pager.appendChild(node);
                }
                this.container.appendChild(pager);

                this.events();
                this.repage(1,1,this.action);
                return;
            }

            for(var i=0 ; i < 9 ; i++){
                var node = document.createElement('div');
                pager.appendChild(node);
                switch (i){
                    case 0:
                        node.className = 'first';
                        break;
                    case 1:
                        node.className = 'prev';
                        break;
                    case 7:
                        node.className = 'next';
                        break;
                    case 8:
                        node.className = 'last';
                    default:
                }
            }
            this.container.appendChild(pager);
            this.events();
            this.repage(pageNumber,pageNumber,this.action);
        }

    }
});