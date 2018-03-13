(function(w,d,u){
	var plist = util.get('plist');
	if(!plist){
		return;
	}
	var layer = new Layer();
	var loading = new Loading();
	var page = {
		init:function(){
			var that = this;
			plist.addEventListener('click',function(e){
				var ele = e.target;
				var delId = ele.dataset && ele.dataset.del;
				if(delId){
					that.ondel(delId);
					return;
				}
			},false);
		},
		ondel:function(id){
			var that = this;
			layer.reset({
				content:'确定要删除该内容吗？',
				onconfirm:function(){
					layer.hide();
					loading.show();
					ajax({
						url:'/deleteContent',
						data:{contentId:id},
						success:function(){
							that.delItemNode(id);
							loading.result('删除成功');
						},
						error:function(){
							loading.result('删除失败');
						}
					});
				}
			}).show();
		},
		delItemNode:function(id){
			var item = util.get('p-'+id);
			if(item && item.parentNode){
				item.parentNode.removeChild(item);
			}
		}
	};
	page.init();
})(window,document);