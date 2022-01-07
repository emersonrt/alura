"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var __param = (this && this.__param) || function (paramIndex, decorator) {
    return function (target, key) { decorator(target, key, paramIndex); }
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.LivrosController = void 0;
const common_1 = require("@nestjs/common");
const livro_model_1 = require("./livro.model");
const livros_service_1 = require("./livros.service");
let LivrosController = class LivrosController {
    constructor(livrosService) {
        this.livrosService = livrosService;
    }
    async obterTodos() {
        return this.livrosService.obterTodos();
    }
    async obterUm(params) {
        return this.livrosService.obterUm(params.id);
    }
    criar(livro) {
        this.livrosService.criar(livro);
    }
    async alterar(livro) {
        return this.livrosService.alterar(livro);
    }
    async apagar(params) {
        this.livrosService.apagar(params.id);
    }
};
__decorate([
    (0, common_1.Get)(),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", []),
    __metadata("design:returntype", Promise)
], LivrosController.prototype, "obterTodos", null);
__decorate([
    (0, common_1.Get)('/:id'),
    __param(0, (0, common_1.Param)()),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", [Object]),
    __metadata("design:returntype", Promise)
], LivrosController.prototype, "obterUm", null);
__decorate([
    (0, common_1.Post)(),
    __param(0, (0, common_1.Body)()),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", [livro_model_1.Livro]),
    __metadata("design:returntype", void 0)
], LivrosController.prototype, "criar", null);
__decorate([
    (0, common_1.Put)(),
    __param(0, (0, common_1.Body)()),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", [livro_model_1.Livro]),
    __metadata("design:returntype", Promise)
], LivrosController.prototype, "alterar", null);
__decorate([
    (0, common_1.Delete)('/:id'),
    __param(0, (0, common_1.Param)()),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", [Object]),
    __metadata("design:returntype", Promise)
], LivrosController.prototype, "apagar", null);
LivrosController = __decorate([
    (0, common_1.Controller)('livros'),
    __metadata("design:paramtypes", [livros_service_1.LivrosService])
], LivrosController);
exports.LivrosController = LivrosController;
//# sourceMappingURL=livros.controller.js.map