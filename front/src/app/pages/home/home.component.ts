import { Component } from '@angular/core';
import { HeaderComponent } from '../../header/header.component';
import { ContentComponent } from '../../content/content.component';
import { FooterComponent } from '../../footer/footer.component';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [HeaderComponent, ContentComponent, FooterComponent],
  template: `
  <app-header></app-header>
  <app-content></app-content>
  <app-footer></app-footer>
`,
  styleUrl: './home.component.css'
})
export class HomeComponent {

}
