import { Component } from '@angular/core';
import { HeaderComponent } from "../../header/header.component";
import { CardModule } from 'primeng/card';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [HeaderComponent, CardModule],
  template: `
  <p-card id="eu"   class="loginCard" >
    <h1 style="margin-top: -30px;
    text-align: center !important;
    color: rgb(255, 0, 0);">login</h1>
      <p class="m-0">
          Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore sed consequuntur error repudiandae numquam deserunt quisquam repellat libero asperiores earum nam nobis, culpa ratione quam perferendis esse, cupiditate neque
          quas!
      </p>
  </p-card>
`,
  styleUrl: './login.component.css'
})
export class LoginComponent {

}
