$('document')
		.ready(
				function() {

					function addCake(cakeObj, parent) {
						var current = {
							id : cakeObj.id,
							name : cakeObj.name,
							quantity : 1
						};

						var cakeItem = $('<div class="cakeItem" />');

						var photof = function() {
							var photo = $('<div class="photo" />');
							var img = $('<img src="' + cakeObj.img + '" height="145" width="180" />');
							photo.append(img);
							return photo;
						};

						var cakeInfof = function() {
							var cakeInfo = $('<div class="cakeContent" />');

							var cakef = function() {
								var cake = $('<div id="cake'
										+ cakeObj.id
										+ '" class="cakeRealContent" style="display: block" />');
								var cakeName = $('<h4 class="cakeName">'
										+ cakeObj.name + '</h4>');
								var cakeCategories = $('<h4>Категории:</h4> ' + cakeObj.categories);
								var cakeContentTitle = $('<h4>Рецепта:</h4>');
								var cakeContent = $('<span>' + cakeObj.recipe.substr(0,200)
										+ '... </span>');
								cake.append(cakeName);
								cake.append(cakeCategories);
								cake.append(cakeContentTitle);
								cake.append(cakeContent);
								return cake;
							};
							var cake = cakef();
							cakeInfo.append(cake);
							return cakeInfo;
						};

						cakeItem.append(photof());
						cakeItem.append(cakeInfof());

						parent.append(cakeItem);
						return cakeObj.id;
					}

					function getCakeItem(id) {
						var result;
						$(cakes).each(function() {
							if (this.id == id) {
								result = this;
							}
						});
						return result;
					}

					$.fn.load = function(request, server_url) {
						$.ajax({
							url : server_url,
							dataType : 'json',
							async : false,
							data : {
								'request' : JSON.stringify(request)
							},
							success : function(data) {
								$('#content *').remove();
								$(data).each(function() {
									addCake(this, $('#content'));
								});
							}
						});
					};
				});