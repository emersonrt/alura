import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Transferencia } from '../models/transferencia.model';
import { TransferenciaService } from '../services/transferencia.service';

@Component({
  selector: 'app-nova-transferencia',
  templateUrl: './nova-transferencia.component.html',
  styleUrls: ['./nova-transferencia.component.scss']
})
export class NovaTransferenciaComponent implements OnInit {

  @Output() aoTransferir = new EventEmitter<any>();
  @Output() valoresComErro = new EventEmitter<String>();

  valor: number;
  destino: string;

  constructor(private service: TransferenciaService) { }

  ngOnInit(): void {
  }

  transferir() {
    console.log('Solicitada nova transferência');
    const valorEmitir: Transferencia = { valor: this.valor, destino: this.destino };
    this.service.adicionar(valorEmitir).subscribe(resultado => {
      console.log(resultado);
      this.limparCampos();
    },
    error => {
      console.error(error);
    });
  }

  limparCampos() {
    this.valor = 0;
    this.destino = '0';
  }

}
