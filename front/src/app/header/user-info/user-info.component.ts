import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-user-info',
  standalone: true,
  imports: [],
  template: `
    <div id="user-info">
      <span>Seja bem-vindo, <strong>{{username}}</strong></span>
      <button>Sair</button>
    </div>
  `,
  styleUrl: './user-info.component.css'
})
export class UserInfoComponent {
  username = "Username Teste";
  //TO-DO esse username deve ser puxado de um service : )
}
