import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-chatbot',
  templateUrl: './chatbot.component.html',
  styleUrl: './chatbot.component.css'
})
export class ChatbotComponent {
  ngOnInit(): void {
    this.loadChatWidget();
  }
  userId: string = "";

  constructor(private route: ActivatedRoute, private router: Router) {
    this.route.queryParams.subscribe(params => {
        this.userId = params['id'];
    });
    console.log(this.userId)
  }

  private loadChatWidget(): void {
    
    const chatWidgetElement = document.getElementById('chat-widget');

    // Verificación de nulidad antes de acceder a las propiedades
    if (chatWidgetElement) {
      const chatProjectUrl = 'http://24.144.89.34:3000/'; // Reemplaza con tu URL real
      const iframe = document.createElement('iframe');
      iframe.src = chatProjectUrl;
      const aspectRatio = 16 / 9; // Puedes ajustar esto según la relación de aspecto deseada
      const maxWidth = window.innerWidth; // Por ejemplo, el 80% del ancho de la ventana
      const maxHeight = maxWidth / aspectRatio;

      iframe.src = chatProjectUrl;
      iframe.width = maxWidth + 'px';
      iframe.height = maxHeight + 'px';
      chatWidgetElement.appendChild(iframe);
    } else {
      console.error('Elemento "chat-widget" no encontrado en el DOM.');
    }
  }
}
