var app = (function(){
	var init = function(context) {
		session.init(context);
		onCreate();
		member.init();
		user.init();
		account.init();
		kaup.init();
		grade.init();
		nav.init();
		admin.init();
	};
	var context = function(){return session.getContextPath();};
	var js = function(){return session.getJavascriptPath('js');};
	var css = function(){return session.getCssPath('css');};
	var img = function(){return session.getImagePath('img');};
	var setContentView = function(){
		$('#header_brand').attr('src',app.img()+'/hanbit.jpg').css('height','80px').css('width','100px').css('padding-bottom','20px');
		$('#footer').addClass('bottom').addClass('footer');
		$('#global_content').addClass('box');
		$('#global_content a').addClass('cursor');
		$('#global_content_a_regist').text('SIGN UP').click(function(){controller.move('member','regist');});
		$('#global_content_a_login').text('LOG IN').click(function(){controller.move('member','login');});
		$('#global_content_a_admin').text('ADMIN MODE').click(function(){admin.check();});
	};
	var onCreate = function(){
		setContentView();
		$('#title').click(function(){controller.home();});
		$('#a_member').click(function(){controller.move('member','main');});
		$('#a_grade').click(function(){controller.move('grade','main');});
		$('#a_account').click(function(){controller.move('account','main');});
		$('#a_shool').click(function(){controller.move('global','school_info');});
	};
	
	return {
		init : init,
		onCreate : onCreate,
		setContentView : setContentView,
		context : context,
		img : img,
		js : js,
		css : css
	}
})();
var user = (function(){
	var init = function(){onCreate();};
	var setContentView = function(){
		$('#member_content_img_home').attr('src',app.img()+'/home.png');
	};
	var onCreate = function(){
		setContentView();
		$('#bt_bom').click(function(){controller.move('','bom');});
		$('#bt_dom').click(function(){controller.move('','dom');});
		$('#bt_kaup').click(function(){controller.move('','kaup');});
		$('#bt_account').click(function(){controller.move('','account');});
		$('#a_regist').click(function(){controller.move('account','regist');});
		$('#a_withdraw').click(function(){controller.move('account','withdraw');});
		$('#a_deposit').click(function(){controller.move('account','deposit');});
		$('#a_list').click(function(){controller.move('account','list');});
		$('#a_update').click(function(){controller.move('account','update');});
		$('#a_count').click(function(){controller.move('account','count');});
		$('#a_search').click(function(){controller.move('account','search');});
		$('#a_delete').click(function(){controller.move('account','delete');});
	};
	return {
		init : init
	};
})();
var account = (function(){
	var _account_no,_money;
	var setAccountNo = function(account_no){this._account_no=account_no;};
	var getAccountNo = function(){return this._account_no;};
	var setMoney = function(money){this._money=money;};
	var getMoney = function(){return this._money;};
	var init = function(){onCreate();};
	var setContentView = function(){};
	var onCreate = function(){
		setContentView();
		/*$('#bt_spec_show').click(member.spec());
		$('#bt_make_account').click(this.spec());
		$('#bt_deposit').click(this.deposit());
		$('#bt_withdraw').click(this.withdraw());*/
	};
	return {
		setAccountNo : setAccountNo,
		getAccountNo : getAccountNo,
		setMoney : setMoney,
		getMoney : getMoney,
		init : init,
		spec : function(){
			/*setAccountNo(Math.floor(Math.random()*899999)+100000);
			setMoney(0);
			document.querySelector('#result_account').innerHTML = getAccountNo();*/
		},
		deposit : function (){
			var r_acc = document.querySelector('#result_account').innerText;
			console.log('ACCOUNT NO : '+r_acc);
			switch(typeof r_acc){
				case 'number' : console.log('this is number type');break;
				case 'string' : console.log('this is string type');break;
				case 'undefined' : console.log('this is undefined type');break;
				default : console.log('type check fail !!');
			}
			if(r_acc == null){
				// r_acc === undefined
				alert('먼저 통장이 개설되어야 합니다');
			}else{
				var input_money = Number(document.querySelector('#money').value);
				var rest_money = getMoney();
				console.log('TYPE CHECK OF INPUT MONEY : '+(typeof input_money === 'number'));
				console.log('TYPE CHECK OF REST MONEY : '+(typeof rest_money === 'number'));
				setMoney(input_money+rest_money);
				console.log('INPUT MONEY : '+getMoney());
				document.querySelector('#rest_money').innerHTML=getMoney();
			}
		},
		withdraw : function (){
			setMoney(document.querySelector('#money').value);
			document.querySelector('#rest_money').innerHTML='-'+getMoney();
		}
	};
})();
var member = (function(){
	var _age,_gender,_name,_ssn;
	var setAge = function(age){this._age=age;}
	var setGender = function(gender){this._gender=gender;}
	var setSSN = function(ssn){this._ssn=ssn;}
	var setName = function(name){this._name=name;}
	var getAge = function(){return this._age;}
	var getSSN = function(){return this._ssn;}
	var getName = function(){return this._name;}
	var getGender = function(){return this._gender;}
	var init = function(){onCreate()};
	var setContentView = function(){
		$('#member_content_img_home').attr('src',app.img()+'/home.png').css('width','30px');
		$('#member_content_a_home').attr('alt','home').click(function(){controller.home();});
		$('#member_content').addClass('box').css('font-size','20px');
		$('#member_content > article').css('width','300px').addClass('center').addClass('text_left');
		$('#member_content a').css('font-size','15px').addClass('cursor');
		$('#member_content > h1').text('MEMBER MGMT');
		$('#member_content_ol > li > a').addClass('remove_underline');
		$('#member_content_ol > li:first > a').text('SIGN UP');
		$('#member_content_ol > li:nth(1) > a').text('DETAIL');
		$('#member_content_ol > li:nth(2) > a').text('UPDATE');
		$('#member_content_ol > li:nth(3) > a').text('DELETE');
		$('#member_content_ol > li:nth(4) > a').text('LOG IN');
		$('#member_content_ol > li:nth(5) > a').text('LOG OUT');
		$('#member_content_ol > li:nth(6) > a').text('LIST');
		$('#member_content_ol > li:nth(7) > a').text('SEARCH');
		$('#member_content_ol > li:nth(8) > a').text('COUNT');
		$('#member_regist').addClass('box');
		$('#member_regist #bt_join').addClass('btn').addClass(' btn-primary');
		$('#member_regist #bt_cancel').addClass('btn').addClass(' btn-danger');
		$('#member_regist_form').addClass('form-horizontal');
		$('#member_regist_form > div').addClass('form-group').addClass('form-group-lg');
		$('#member_regist_form > div > label').addClass('col-sm-2').addClass('control-label');
		$('#member_regist_form > div > div').addClass('col-sm-10');
		$('#member_regist_form > div > div > input').addClass('form-control');
		$('#member_regist #rd_major > label:gt(1)').addClass('radio-inline');
		$('#member_regist #ck_subject').addClass('checkbox');
		$('#member_regist #ck_subject > label').addClass('checkbox-inline');
		$('#member_find_form').attr('action',app.context()+'/member/search');
		$('#member_find_form input[type="hidden"]')
		.attr('name','context')
		.attr('value',app.context());
		
	};
	var onCreate = function(){
		setContentView();
		$('#regist').click(function(){controller.move('member','regist');});
		$('#detail').click(function(){controller.move('member','detail');});
		$('#update').click(function(){controller.move('member','update');});
		$('#delete').click(function(){controller.move('member','delete');});
		$('#login').click(function(){controller.move('member','login');});
		$('#logout').click(function(){controller.move('member','logout');});
		$('#list').click(function(){controller.move('member','list');});
		$('#find_by').click(function(){controller.move('member','find_by');});
		$('#count').click(function(){controller.move('member','count');});
		$('#member_find_form input[type="submit"]').click(function(){$('#member_find_form').submit();});
	};
	return {
		setSSN : setSSN,
		setName : setName,
		setAge : setAge,
		setGender : setGender,
		getName : getName,
		getAge : getAge,
		getSSN : getSSN,
		getGender : getGender,
		init : init,
		spec : function (){
			/*console.log('SET SSN'+document.querySelector('#ssn').value);
			setSSN(document.querySelector('#ssn').value);
			console.log('GET SSN'+getSSN());
			setName(document.querySelector('#name').value);
			var now = new Date().getFullYear();
			var ssnArr = getSSN().split("-");
			var ageResult1 = ssnArr[0];
			var genderResult = Number(ssnArr[1]);
			var ageResult0 = 0;
			switch (genderResult) {
			case 1: case 5: 
				setGender("남"); 
				ageResult0 = now - 1900-(ageResult1/10000);
				setAge(ageResult0.toString().split(".")[0]);
				break;
			case 3: case 7:
				setGender("남");
				ageResult0 = now - 2000-(ageResult1/10000);
				setAge(ageResult0.toString().split(".")[0]);
				break;
			case 2: case 6:
				setGender("여");
				ageResult0 = now - 1900-(ageResult1/10000);
				setAge(ageResult0.toString().split(".")[0]);
				break;
			case 4: case 8:
				setGender("여");
				ageResult0 = now - 2000-(ageResult1/10000);
				setAge(ageResult0.toString().split(".")[0]);
				break;

		}	
			document.querySelector('#result_name').innerHTML = getName();
			document.querySelector('#result_age').innerHTML = getAge();
			document.querySelector('#result_gender').innerHTML = getGender();*/
		}
		
	};	
})();
var kaup = (function(){
	var init = function(){onCreate();};
	var setContentView = function(){};
	var onCreate = function(){
		setContentView();
		//document.getElementById('bt_kaup_calc').addEventListener('click',this.calc,false);
	};
	return {
		init : init,
		calc : function (){
			var name=document.querySelector('#name').value;
			var height=document.querySelector('#height').value;
			var weight=document.querySelector('#weight').value;
			console.log('name'+name);
			console.log('height'+height);
			console.log('weight'+weight);
			var result = '';
			var kaup = weight / (height / 100) / (height / 100);
			if (kaup < 18.5) {
				result = "저체중";
			} else if (kaup < 22.9 && kaup > 18.5) {
				result = "정상";
			} else if (kaup < 24.9 && kaup > 23.0) {
				result = "위험체중";
			} else if (kaup < 29.9 && kaup > 25.0) {
				result = "비만1단계";
			} else if (kaup < 40 && kaup > 30.0) {
				result = "비만2단계";
			} else if (kaup >= 40) {
				result = "비만3단계";
			}
			document.getElementById('result').innerHTML=name+'의 카우푸결과'+result;
		}
	};
})();
var grade = (function(){
	var init = function(){onCreate();};
	var setContentView = function(){
		$('#member_content_img_home').attr('src',app.img()+'/home.png');
		$('#grade_content').addClass('box');
		$('#img_home').css('width','30px');
		$('#grade_content > article').css('width','300px').css('text-align','left').css('margin','0 auto');
		$('#title').css('font-size','40px');
	};
	var onCreate = function(){
		setContentView();
		$('#g_regist').click(function(){controller.move('grade','regist');});
		$('#g_update').click(function(){controller.move('grade','update');});
		$('#g_delete').click(function(){controller.move('grade','delete');});
		$('#g_list').click(function(){controller.move('grade','list');});
		$('#g_count').click(function(){controller.move('grade','count');});
		$('#g_find').click(function(){controller.move('grade','find');});
		$('#a_regist').click(function() {location.href = "${context}/grade/regist.do";});
		$('#a_update').click(function() {location.href ="${context}/grade/update.do";});
		$('#a_delete').click(function() {location.href = "${context}/grade/delete.do";});
		$('#a_list').click(function() {location.href = "${context}/grade/list.do";});
		$('#a_count').click(function() {location.href = "${context}/grade/count.do";});
		$('#a_find').click(function() {location.href = "${context}/grade/search.do";});
	};
	return {
		init : init,
	};
})();

var admin = (function() {
	var _pass;
    var	getPass = function(){return this._pass;};
    var setPass = function(pass){this._pass=pass;};
    var init = function(){onCreate();};
    var setContentView = function(){
    	$('#admin_content #img_1').attr('src',app.img()+'/member_mgmt.PNG');
    	$('#admin_content #img_2').attr('src',app.img()+'/grade_mgmt.PNG');
    	$('#admin_content #img_3').attr('src',app.img()+'/account_mgmt.PNG');
    	$('#admin_content h3').addClass('text_center');
    };
    var onCreate = function(){
    	setContentView();
    	$('#admin_nav #member_mgmt #list').click(function(){controller.move('member','list');});
    	$('#admin_nav #member_mgmt #find_by').click(function(){controller.move('member','find');});
    	$('#admin_nav #member_mgmt #count').click(function(){controller.move('member','count');});
    	$('#admin_nav #account_mgmt #list').click(function(){controller.move('account','list');});
    	$('#admin_nav #account_mgmt #open').click(function(){controller.move('account','open');});
    	$('#admin_nav #account_mgmt #delete').click(function(){controller.move('account','delete');});
    	$('#admin_nav #account_mgmt #find').click(function(){controller.move('account','find');});
    	$('#admin_nav #account_mgmt #count').click(function(){controller.move('account','count');});
    };
    return {
    	getPass : getPass,
    	setPass : setPass,
    	init : init,
    	check : function() {
    		setPass(1);
			var isAdmin = confirm('관리자입니까?');
			if (!isAdmin) {
				alert('관리자만 접근 가능합니다.');
			} else {
				var password = prompt('관리자 비번을 입력바랍니다');
				if(password == getPass()){
					controller.move('admin','main');
				}else{
					alert('관리자 비번이 틀립니다.');
				}
			}
		}
    };
})();
var session = (function(){
	var init = function(context){
		sessionStorage.setItem('context',context);
		sessionStorage.setItem('js',context+'/resources/js');
		sessionStorage.setItem('css',context+'/resources/css');
		sessionStorage.setItem('img',context+'/resources/img');
	};
	var getContextPath = function(){return sessionStorage.getItem('context');};
	var getJavascriptPath = function(){return sessionStorage.getItem('js');};
	var getCssPath = function(){return sessionStorage.getItem('js');};
	var getImagePath = function(){return sessionStorage.getItem('img');};
	return {
		init : init,
		getContextPath : getContextPath,
		getJavascriptPath : getJavascriptPath,
		getCssPath : getCssPath,
		getImagePath : getImagePath
	};
	
})();
var controller = (function(){
	var _page,_directory;
	var setPage=function(page){this._page=page;};
	var setDirectory=function(directory){this._directory=directory;};
	var getPage = function(){return this._page;};
	var getDirectory = function(){return this._directory;};
	return {
		setPage : setPage,
		getPage : getPage,
		setDirectory : setDirectory,
		getDirectory : getDirectory,
		move : function(directory,page){
			setDirectory(directory);
			setPage(page);
			location.href = app.context()+'/'+getDirectory()+'/'+getPage();
		},
		home : function(){location.href=app.context()+'/'}
	};
})();
var util = (function(){
	return {
		isNumber : function(value){
			return typeof value === 'number' && isFinite(value);
		}
	};
})();
var nav = (function(){
	var init = function(){onCreate();};
	var setContentView = function(){
		$('#nav ul').addClass('list_style_none').addClass('over_hidden').addClass('bg_color_black')
		.css('margin','0').css('padding','0');
		$('#nav li').addClass('float_left').addClass('display_inline')
		.css('border-right','1px').css('solid','#bbb');
		$('#nav li:last-child').css('border-right','none');
		$('#nav li a').addClass('display_block').addClass('font_color_white').addClass('text_center').addClass('text_deco_none')
		.css('padding','14px 16px')
		$('#nav li a:hover:not(.active)').addClass('bg_color_green')
		$('#nav .active').addClass('bg_color_black');
	};
	var onCreate = function(){
		setContentView();
	};
	return {
		init : init
	};
})();






