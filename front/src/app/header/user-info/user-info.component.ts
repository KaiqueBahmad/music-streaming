import { Component, Input } from '@angular/core';
import { DButtonComponent } from '../../components/d-button/d-button.component';

@Component({
  selector: 'app-user-info',
  standalone: true,
  imports: [DButtonComponent],
  template: `
    <div id="user-info">
      <span>Seja bem-vindo, <strong>{{username}}</strong></span>
      <app-d-button text="Sair" redirect="/sair" />
    </div>
  `,
  styleUrl: './user-info.component.css'
})
export class UserInfoComponent {
  username = "Username Teste";
  //TO-DO esse username deve ser puxado de um service : )
}
