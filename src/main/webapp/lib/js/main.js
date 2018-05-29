webpackJsonp([0],{

/***/ 109:
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncatched exception popping up in devtools
	return Promise.resolve().then(function() {
		throw new Error("Cannot find module '" + req + "'.");
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = 109;

/***/ }),

/***/ 150:
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncatched exception popping up in devtools
	return Promise.resolve().then(function() {
		throw new Error("Cannot find module '" + req + "'.");
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = 150;

/***/ }),

/***/ 193:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return HomePage; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(40);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var HomePage = /** @class */ (function () {
    function HomePage(navCtrl) {
        this.navCtrl = navCtrl;
    }
    HomePage = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["m" /* Component */])({
            selector: 'page-home',template:/*ion-inline-start:"/home/gislainy/work/sempreufg/client/src/pages/home/home.html"*/'<ion-header>\n  <ion-navbar>\n    <button ion-button menuToggle>\n      <ion-icon name="menu"></ion-icon>\n    </button>\n    <ion-title>Home</ion-title>\n  </ion-navbar>\n</ion-header>\n\n<ion-content padding>\n  <h3>Ionic Menu Starter</h3>\n\n  <p>\n    If you get lost, the <a href="http://ionicframework.com/docs/v2">docs</a> will show you the way.\n  </p>\n\n  <button ion-button secondary menuToggle>Toggle Menu</button>\n</ion-content>\n'/*ion-inline-end:"/home/gislainy/work/sempreufg/client/src/pages/home/home.html"*/
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["e" /* NavController */]])
    ], HomePage);
    return HomePage;
}());

//# sourceMappingURL=home.js.map

/***/ }),

/***/ 194:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SufgLoginComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular_navigation_nav_controller__ = __webpack_require__(15);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__sufg_cadastrar_usuario_sufg_cadastrar_usuario__ = __webpack_require__(195);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



/**
 * Generated class for the SufgLoginComponent component.
 *
 * See https://angular.io/api/core/Component for more info on Angular
 * Components.
 */
var SufgLoginComponent = /** @class */ (function () {
    function SufgLoginComponent(navCtrl) {
        this.navCtrl = navCtrl;
        this.user = {};
    }
    SufgLoginComponent.prototype.registrar = function () {
        debugger;
        this.navCtrl.push(__WEBPACK_IMPORTED_MODULE_2__sufg_cadastrar_usuario_sufg_cadastrar_usuario__["a" /* SufgCadastrarUsuarioComponent */]);
    };
    SufgLoginComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["m" /* Component */])({
            selector: 'sufg-login',template:/*ion-inline-start:"/home/gislainy/work/sempreufg/client/src/components/sufg-login/sufg-login.html"*/'<ion-content padding ="sufg">\n  <ion-grid style="height: 100%">\n    <ion-row justify-content-center align-items-center style="height: 100%">\n      <div col-12 col-md-6>\n        <div col-12 text-center>\n          <img src="lib/img/logo.svg" />\n        </div>\n        <ion-item>\n          <ion-label floating>Identificador único</ion-label>\n          <ion-input type="text" [(ngModel)]="user.identificador"></ion-input>\n        </ion-item>\n\n        <ion-item>\n          <ion-label floating>Senha</ion-label>\n          <ion-input type="password" [(ngModel)]="user.password"></ion-input>\n        </ion-item>\n\n        <ion-grid>\n          <ion-row>\n            <button col-12 color="entrar" ion-button (tap)="login(user)">Entrar</button>\n          </ion-row>\n        </ion-grid>\n\n        <ion-grid>\n          <ion-row>\n            <ion-col col-6>\n              <button col-12 color="facebook" ion-button (tap)="loginFacebook()">\n                <ion-icon padding name="logo-facebook"></ion-icon>Facebook\n              </button>\n            </ion-col>\n            <ion-col col-6>\n              <button col-12 color="google" ion-button (tap)="loginGoogle()">\n                <ion-icon padding name="logo-google"></ion-icon>Google</button>\n            </ion-col>\n          </ion-row>\n        </ion-grid>\n        <ion-label class="cadastrar" text-center (tap)="registrar()">Cadastre-se</ion-label>\n      </div>\n    </ion-row>\n  </ion-grid>\n</ion-content>'/*ion-inline-end:"/home/gislainy/work/sempreufg/client/src/components/sufg-login/sufg-login.html"*/
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_ionic_angular_navigation_nav_controller__["a" /* NavController */]])
    ], SufgLoginComponent);
    return SufgLoginComponent;
}());

//# sourceMappingURL=sufg-login.js.map

/***/ }),

/***/ 195:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SufgCadastrarUsuarioComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__sufg_cadastro_usuario_dado__ = __webpack_require__(273);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_ionic_angular_components_toast_toast_controller__ = __webpack_require__(95);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_ionic_angular_navigation_nav_controller__ = __webpack_require__(15);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__sufg_usuario_sufg_usuario__ = __webpack_require__(196);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





/**
 * Generated class for the SufgCadastrarUsuarioComponent component.
 *
 * See https://angular.io/api/core/Component for more info on Angular
 * Components.
 */
var SufgCadastrarUsuarioComponent = /** @class */ (function () {
    function SufgCadastrarUsuarioComponent(toastCtrl, navCtrl) {
        this.toastCtrl = toastCtrl;
        this.navCtrl = navCtrl;
        this.perguntaAtual = 0;
        this.respostas = [];
        this.finalizou = false;
        this.pergunta = __WEBPACK_IMPORTED_MODULE_1__sufg_cadastro_usuario_dado__["a" /* listaDePerguntas */][this.perguntaAtual];
    }
    SufgCadastrarUsuarioComponent.prototype.avancar = function () {
        var _this = this;
        if (!this.alternativa) {
            this.toastCtrl.create({
                message: 'Escolha pelo menos uma alternativa!',
                duration: 3000,
                position: 'top',
            }).present();
        }
        else {
            if (this.respostas.every(function (r) { return r.perguntaId != _this.pergunta._id; })) {
                var obj = {
                    perguntaId: this.pergunta._id,
                    resposta: this.alternativa
                };
                this.respostas.push(obj);
            }
            else {
                this.respostas = this.respostas.map(function (r) {
                    if (r.perguntaId === _this.pergunta._id) {
                        r.resposta = _this.alternativa;
                    }
                    return r;
                });
            }
            this.alternativa = null;
            this.perguntaAtual++;
            if ((__WEBPACK_IMPORTED_MODULE_1__sufg_cadastro_usuario_dado__["a" /* listaDePerguntas */].length - 1) != this.perguntaAtual)
                this.pergunta = __WEBPACK_IMPORTED_MODULE_1__sufg_cadastro_usuario_dado__["a" /* listaDePerguntas */][this.perguntaAtual];
            else
                this.finalizou = true;
        }
    };
    SufgCadastrarUsuarioComponent.prototype.concluir = function () {
        if (this.finalizou) {
            debugger;
            var estaoCorreta = this.respostas.every(function (r) {
                return __WEBPACK_IMPORTED_MODULE_1__sufg_cadastro_usuario_dado__["a" /* listaDePerguntas */].some(function (p) {
                    if (p._id === r.perguntaId) {
                        return p.alternativas.some(function (a) {
                            if (a.title == r.resposta)
                                return a.correta;
                        });
                    }
                });
            });
            if (estaoCorreta) {
                this.navCtrl.push(__WEBPACK_IMPORTED_MODULE_4__sufg_usuario_sufg_usuario__["a" /* SufgUsuarioComponent */]);
            }
            else {
                this.toastCtrl.create({
                    message: 'Desculpa, os dados informados não corresponde! Tente novamente ou contacta o nosso suporte!',
                    position: 'top',
                    duration: 6000,
                }).present();
                this.finalizou = false;
            }
            console.log('estaoCorreta', estaoCorreta);
        }
    };
    SufgCadastrarUsuarioComponent.prototype.voltar = function () {
        this.finalizou = false;
        this.perguntaAtual--;
        this.pergunta = __WEBPACK_IMPORTED_MODULE_1__sufg_cadastro_usuario_dado__["a" /* listaDePerguntas */][this.perguntaAtual];
    };
    SufgCadastrarUsuarioComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["m" /* Component */])({
            selector: 'sufg-cadastrar-usuario',template:/*ion-inline-start:"/home/gislainy/work/sempreufg/client/src/components/sufg-cadastrar-usuario/sufg-cadastrar-usuario.html"*/'<ion-content padding ="sufg">\n  <ion-grid style="height: 100%">\n    <ion-row justify-content-center align-items-center style="height: 100%">\n      <div col-12 col-md-6>\n        <h1 ion-text text-center color="primary">{{pergunta.nome}}</h1>\n        <ion-list radio-group [(ngModel)]="alternativa">\n          <ion-item *ngFor="let a of pergunta.alternativas">\n            <ion-label>{{a.title}}</ion-label>\n            <ion-radio value="{{a.title}}" ></ion-radio>\n          </ion-item>\n        </ion-list>\n        <ion-grid>\n          <ion-row>\n            <ion-col col-6>\n              <button *ngIf="perguntaAtual" col-12 color="secondary" ion-button (tap)="voltar()">\n                <ion-icon padding name="ios-arrow-dropleft"></ion-icon>Voltar\n              </button>\n            </ion-col>\n            <ion-col col-6 *ngIf="!finalizou" >\n              <button   col-12 color="primary" ion-button (tap)="avancar()">\n                Avançar<ion-icon padding name="ios-arrow-dropright"></ion-icon></button>\n            </ion-col>\n            <ion-col col-6 *ngIf="finalizou">\n              <button   col-12 color="danger" ion-button (tap)="concluir()">\n               Concluir <ion-icon padding name="ios-checkmark-circle"></ion-icon></button>\n            </ion-col>\n          </ion-row>\n        </ion-grid>\n      </div>\n    </ion-row>\n  </ion-grid>\n</ion-content>'/*ion-inline-end:"/home/gislainy/work/sempreufg/client/src/components/sufg-cadastrar-usuario/sufg-cadastrar-usuario.html"*/
        }),
        __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_2_ionic_angular_components_toast_toast_controller__["a" /* ToastController */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2_ionic_angular_components_toast_toast_controller__["a" /* ToastController */]) === "function" && _a || Object, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_3_ionic_angular_navigation_nav_controller__["a" /* NavController */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3_ionic_angular_navigation_nav_controller__["a" /* NavController */]) === "function" && _b || Object])
    ], SufgCadastrarUsuarioComponent);
    return SufgCadastrarUsuarioComponent;
    var _a, _b;
}());

//# sourceMappingURL=sufg-cadastrar-usuario.js.map

/***/ }),

/***/ 196:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SufgUsuarioComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__sufg_login_sufg_login__ = __webpack_require__(194);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_ionic_angular_navigation_nav_controller__ = __webpack_require__(15);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



/**
 * Generated class for the SufgUsuarioComponent component.
 *
 * See https://angular.io/api/core/Component for more info on Angular
 * Components.
 */
var SufgUsuarioComponent = /** @class */ (function () {
    function SufgUsuarioComponent(navCtrl) {
        this.navCtrl = navCtrl;
        this.user = {};
        console.log('Hello SufgUsuarioComponent Component');
        this.text = 'Hello World';
    }
    SufgUsuarioComponent.prototype.finalizar = function () {
        this.navCtrl.push(__WEBPACK_IMPORTED_MODULE_1__sufg_login_sufg_login__["a" /* SufgLoginComponent */]);
    };
    SufgUsuarioComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["m" /* Component */])({
            selector: 'sufg-usuario',template:/*ion-inline-start:"/home/gislainy/work/sempreufg/client/src/components/sufg-usuario/sufg-usuario.html"*/'<ion-content padding ="sufg">\n  <ion-grid style="height: 100%">\n    <ion-row justify-content-center align-items-center style="height: 100%">\n      <div col-12 col-md-6>\n        <h1 ion-text text-center color="primary">Pronto! Agora você pode definir os seus dados cadastrais :D</h1>\n        <ion-item>\n          <ion-label floating>Identificador único (CPF ou E-mail)</ion-label>\n          <ion-input type="text" [(ngModel)]="user.identificador"></ion-input>\n        </ion-item>\n\n        <ion-item>\n          <ion-label floating>Senha</ion-label>\n          <ion-input type="password" [(ngModel)]="user.password"></ion-input>\n        </ion-item>\n        <ion-item>\n          <ion-label floating>Digite novamente a senha</ion-label>\n          <ion-input type="password" [(ngModel)]="user.password2"></ion-input>\n        </ion-item>\n\n        <ion-grid>\n          <ion-row>\n            <button col-12 color="entrar" ion-button (tap)="finalizar()">Cadastrar meu usuário</button>\n          </ion-row>\n        </ion-grid>\n      </div>\n    </ion-row>\n  </ion-grid>\n</ion-content>'/*ion-inline-end:"/home/gislainy/work/sempreufg/client/src/components/sufg-usuario/sufg-usuario.html"*/
        }),
        __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_2_ionic_angular_navigation_nav_controller__["a" /* NavController */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2_ionic_angular_navigation_nav_controller__["a" /* NavController */]) === "function" && _a || Object])
    ], SufgUsuarioComponent);
    return SufgUsuarioComponent;
    var _a;
}());

//# sourceMappingURL=sufg-usuario.js.map

/***/ }),

/***/ 197:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser_dynamic__ = __webpack_require__(198);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__app_module__ = __webpack_require__(220);


Object(__WEBPACK_IMPORTED_MODULE_0__angular_platform_browser_dynamic__["a" /* platformBrowserDynamic */])().bootstrapModule(__WEBPACK_IMPORTED_MODULE_1__app_module__["a" /* AppModule */]);
//# sourceMappingURL=main.js.map

/***/ }),

/***/ 220:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__ = __webpack_require__(30);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_ionic_angular__ = __webpack_require__(40);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__app_component__ = __webpack_require__(263);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__pages_home_home__ = __webpack_require__(193);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__components_sufg_login_sufg_login__ = __webpack_require__(194);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__components_sufg_cadastrar_usuario_sufg_cadastrar_usuario__ = __webpack_require__(195);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__ionic_native_status_bar__ = __webpack_require__(189);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__ionic_native_splash_screen__ = __webpack_require__(192);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__components_sufg_usuario_sufg_usuario__ = __webpack_require__(196);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};










var pages = [
    { component: __WEBPACK_IMPORTED_MODULE_4__pages_home_home__["a" /* HomePage */], name: "Home", segment: "home" },
    { component: __WEBPACK_IMPORTED_MODULE_5__components_sufg_login_sufg_login__["a" /* SufgLoginComponent */], name: "Login", segment: "login" },
    { component: __WEBPACK_IMPORTED_MODULE_6__components_sufg_cadastrar_usuario_sufg_cadastrar_usuario__["a" /* SufgCadastrarUsuarioComponent */], name: "Validar Usuário", segment: "validar-usuario" },
    { component: __WEBPACK_IMPORTED_MODULE_9__components_sufg_usuario_sufg_usuario__["a" /* SufgUsuarioComponent */], name: "Cadastrar Usuário", segment: "cadastrar-usuario" },
];
var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["I" /* NgModule */])({
            declarations: [
                __WEBPACK_IMPORTED_MODULE_3__app_component__["a" /* MyApp */]
            ].concat(pages.map(function (p) { return p.component; })),
            imports: [
                __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__["a" /* BrowserModule */],
                __WEBPACK_IMPORTED_MODULE_2_ionic_angular__["c" /* IonicModule */].forRoot(__WEBPACK_IMPORTED_MODULE_3__app_component__["a" /* MyApp */], {}, {
                    links: pages
                }),
            ],
            bootstrap: [__WEBPACK_IMPORTED_MODULE_2_ionic_angular__["a" /* IonicApp */]],
            entryComponents: [
                __WEBPACK_IMPORTED_MODULE_3__app_component__["a" /* MyApp */]
            ].concat(pages.map(function (p) { return p.component; })),
            providers: [
                __WEBPACK_IMPORTED_MODULE_7__ionic_native_status_bar__["a" /* StatusBar */],
                __WEBPACK_IMPORTED_MODULE_8__ionic_native_splash_screen__["a" /* SplashScreen */],
                { provide: __WEBPACK_IMPORTED_MODULE_1__angular_core__["u" /* ErrorHandler */], useClass: __WEBPACK_IMPORTED_MODULE_2_ionic_angular__["b" /* IonicErrorHandler */] }
            ]
        })
    ], AppModule);
    return AppModule;
}());

//# sourceMappingURL=app.module.js.map

/***/ }),

/***/ 263:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return MyApp; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(40);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__ionic_native_status_bar__ = __webpack_require__(189);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__ionic_native_splash_screen__ = __webpack_require__(192);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__pages_home_home__ = __webpack_require__(193);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__pages_list_list__ = __webpack_require__(272);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__components_sufg_login_sufg_login__ = __webpack_require__(194);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};







var MyApp = /** @class */ (function () {
    function MyApp(platform, statusBar, splashScreen) {
        this.platform = platform;
        this.statusBar = statusBar;
        this.splashScreen = splashScreen;
        this.rootPage = __WEBPACK_IMPORTED_MODULE_6__components_sufg_login_sufg_login__["a" /* SufgLoginComponent */];
        this.initializeApp();
        // used for an example of ngFor and navigation
        this.pages = [
            { title: 'Home', component: __WEBPACK_IMPORTED_MODULE_4__pages_home_home__["a" /* HomePage */] },
            { title: 'List', component: __WEBPACK_IMPORTED_MODULE_5__pages_list_list__["a" /* ListPage */] }
        ];
    }
    MyApp.prototype.initializeApp = function () {
        var _this = this;
        this.platform.ready().then(function () {
            // Okay, so the platform is ready and our plugins are available.
            // Here you can do any higher level native things you might need.
            _this.statusBar.styleDefault();
            _this.splashScreen.hide();
        });
    };
    MyApp.prototype.openPage = function (page) {
        // Reset the content nav to have just this page
        // we wouldn't want the back button to show in this scenario
        this.nav.setRoot(page.component);
    };
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_8" /* ViewChild */])(__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["d" /* Nav */]),
        __metadata("design:type", __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["d" /* Nav */])
    ], MyApp.prototype, "nav", void 0);
    MyApp = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["m" /* Component */])({template:/*ion-inline-start:"/home/gislainy/work/sempreufg/client/src/app/app.html"*/'<ion-menu [content]="content">\n  <ion-header>\n    <ion-toolbar>\n      <ion-title>Menu</ion-title>\n    </ion-toolbar>\n  </ion-header>\n\n  <ion-content>\n    <ion-list>\n      <button menuClose ion-item *ngFor="let p of pages" (click)="openPage(p)">\n        {{p.title}}\n      </button>\n    </ion-list>\n  </ion-content>\n\n</ion-menu>\n\n<!-- Disable swipe-to-go-back because it\'s poor UX to combine STGB with side menus -->\n<ion-nav [root]="rootPage" #content swipeBackEnabled="false"></ion-nav>'/*ion-inline-end:"/home/gislainy/work/sempreufg/client/src/app/app.html"*/
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["g" /* Platform */], __WEBPACK_IMPORTED_MODULE_2__ionic_native_status_bar__["a" /* StatusBar */], __WEBPACK_IMPORTED_MODULE_3__ionic_native_splash_screen__["a" /* SplashScreen */]])
    ], MyApp);
    return MyApp;
}());

//# sourceMappingURL=app.component.js.map

/***/ }),

/***/ 272:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ListPage; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(40);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var ListPage = /** @class */ (function () {
    function ListPage(navCtrl, navParams) {
        this.navCtrl = navCtrl;
        this.navParams = navParams;
        // If we navigated to this page, we will have an item available as a nav param
        this.selectedItem = navParams.get('item');
        // Let's populate this page with some filler content for funzies
        this.icons = ['flask', 'wifi', 'beer', 'football', 'basketball', 'paper-plane',
            'american-football', 'boat', 'bluetooth', 'build'];
        this.items = [];
        for (var i = 1; i < 11; i++) {
            this.items.push({
                title: 'Item ' + i,
                note: 'This is item #' + i,
                icon: this.icons[Math.floor(Math.random() * this.icons.length)]
            });
        }
    }
    ListPage_1 = ListPage;
    ListPage.prototype.itemTapped = function (event, item) {
        // That's right, we're pushing to ourselves!
        this.navCtrl.push(ListPage_1, {
            item: item
        });
    };
    ListPage = ListPage_1 = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["m" /* Component */])({
            selector: 'page-list',template:/*ion-inline-start:"/home/gislainy/work/sempreufg/client/src/pages/list/list.html"*/'<ion-header>\n  <ion-navbar>\n    <button ion-button menuToggle>\n      <ion-icon name="menu"></ion-icon>\n    </button>\n    <ion-title>List</ion-title>\n  </ion-navbar>\n</ion-header>\n\n<ion-content>\n  <ion-list>\n    <button ion-item *ngFor="let item of items" (click)="itemTapped($event, item)">\n      <ion-icon [name]="item.icon" item-start></ion-icon>\n      {{item.title}}\n      <div class="item-note" item-end>\n        {{item.note}}\n      </div>\n    </button>\n  </ion-list>\n  <div *ngIf="selectedItem" padding>\n    You navigated here from <b>{{selectedItem.title}}</b>\n  </div>\n</ion-content>\n'/*ion-inline-end:"/home/gislainy/work/sempreufg/client/src/pages/list/list.html"*/
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["e" /* NavController */], __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["f" /* NavParams */]])
    ], ListPage);
    return ListPage;
    var ListPage_1;
}());

//# sourceMappingURL=list.js.map

/***/ }),

/***/ 273:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return listaDePerguntas; });
var listaDePerguntas = [
    {
        _id: "nome_da_mae",
        nome: "Qual nome da sua mãe?",
        alternativas: [
            {
                title: "Maria",
                correta: false,
            },
            {
                title: "Viviane",
                correta: true,
            },
            {
                title: "Antônia ",
                correta: false,
            },
            {
                title: "Vera",
                correta: false,
            },
            {
                title: "Joilma",
                correta: false,
            },
        ]
    },
    {
        _id: "nascimento",
        nome: "Qual é o ano do seu nascimento?",
        alternativas: [
            {
                title: "1987",
                correta: false,
            },
            {
                title: "1986",
                correta: false,
            },
            {
                title: "1997",
                correta: true,
            },
            {
                title: "1993",
                correta: false,
            },
            {
                title: "1990",
                correta: false,
            },
        ]
    },
    {
        _id: "naturalidade",
        nome: "Qual é a sua naturalidade?",
        alternativas: [
            {
                title: "Goiânia",
                correta: true,
            },
            {
                title: "São Bernado do Campo",
                correta: false,
            },
            {
                title: "Anicuns",
                correta: false,
            },
            {
                title: "São Paulo",
                correta: false,
            },
            {
                title: "Aparecida de Goiânia",
                correta: false,
            },
        ]
    },
    {
        _id: "curso",
        nome: "Qual curso você fez na UFG?",
        alternativas: [
            {
                title: "Ciẽncia da Computação",
                correta: false,
            },
            {
                title: "Medicina",
                correta: false,
            },
            {
                title: "Sistema de Informação",
                correta: true,
            },
            {
                title: "Engenharia Eletrica",
                correta: false,
            },
            {
                title: "Sociologia",
                correta: false,
            },
        ]
    },
    {
        _id: "matricula",
        nome: "Qual eram os três últimos digitos da sua matrícula?",
        alternativas: [
            {
                title: "666",
                correta: false,
            },
            {
                title: "178",
                correta: false,
            },
            {
                title: "254",
                correta: false,
            },
            {
                title: "637",
                correta: true,
            },
            {
                title: "621",
                correta: false,
            },
        ]
    },
];
//# sourceMappingURL=sufg-cadastro-usuario-dado.js.map

/***/ })

},[197]);
//# sourceMappingURL=main.js.map