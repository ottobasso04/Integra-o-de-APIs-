// ==========================================
// BLOCO 1: CADASTRAR USUÁRIO VIA JSON
// ==========================================
document.getElementById('formCadastroUsuario').addEventListener('submit', function(event) {
    event.preventDefault();
    const msg = document.getElementById('msgCadastro');

    // Montando o JSON exatamente como o Java espera receber
    const corpoRequisicao = {
        nome: document.getElementById('nome').value,
        telefone: document.getElementById('telefone').value,
        endereco: {
            logradouro: document.getElementById('logradouro').value,
            numero: document.getElementById('numero').value,
            cep: document.getElementById('cep').value,
            bairro: document.getElementById('bairro').value,
            cidade: document.getElementById('cidade').value
        }
    };

    // Disparando o POST (Ajuste a rota/porta conforme o seu Controller)
    fetch("http://localhost:8081/Cadastro de Usuário", { // Substitua pela sua rota de salvar usuário
        method: "POST",
        headers: {
            "Content-Type": "application/json" // Avisa o Java que estamos mandando um JSON
        },
        body: JSON.stringify(corpoRequisicao) // Transforma o objeto JS em texto JSON
    })
    .then(resposta => {
        if (resposta.ok) {
            msg.innerText = "Usuário salvo com sucesso!";
            msg.style.color = "green";
            this.reset(); // Limpa o formulário
        } else {
            msg.innerText = "Erro ao salvar.";
            msg.style.color = "red";
        }
    });
});

// ==========================================
// BLOCO 2: BUSCAR USUÁRIO POR ID
// ==========================================
document.getElementById('formBuscarUsuario').addEventListener('submit', function(event) {
    event.preventDefault();
    const id = document.getElementById('idBusca').value;
    const divResultado = document.getElementById('resultadoBusca');

    // Disparando o GET com o ID na URL
    fetch(`http://localhost:8081/Buscar-usuarios-por-Id/${id}`) // Substitua pela sua rota exata
    .then(resposta => {
        if (resposta.ok) {
            return resposta.json(); // Extrai o JSON que o Java devolveu
        }
        throw new Error("Usuário não encontrado");
    })
    .then(usuario => {
        // Desenhando o resultado na tela
        divResultado.innerHTML = `
            <p><strong>Nome:</strong> ${usuario.nome}</p>
            <p><strong>Telefone:</strong> ${usuario.telefone}</p>
            <p><strong>Cidade:</strong> ${usuario.endereco.cidade}</p>
        `;
    })
    .catch(erro => {
        divResultado.innerHTML = `<p style="color:red;">${erro.message}</p>`;
    });
});

// ==========================================
// BLOCO 3: IMPORTAR PLANILHA (Manteve o mesmo)
// ==========================================
document.getElementById('formImportacao').addEventListener('submit', function(event) {
    event.preventDefault();
    const inputArquivo = document.getElementById('arquivoPlanilha');
    const msg = document.getElementById('msgImportacao');
    
    const formData = new FormData();
    formData.append("file", inputArquivo.files[0]);

    fetch("http://localhost:8081/importar", {
        method: "POST",
        body: formData
    })
    .then(resposta => {
        if (resposta.ok) {
            msg.innerText = "Planilha importada com sucesso!";
            msg.style.color = "green";
            this.reset();
        } else {
            msg.innerText = "Erro ao importar.";
            msg.style.color = "red";
        }
    });
});

// ==========================================
// CADASTRAR PLANILHA COMPLETA
// ==========================================
document.getElementById('formCadastrarPlanilha').addEventListener('submit', function(event) {
    event.preventDefault();
    const msg = document.getElementById('msgCadPlanilha');

    const payload = {
        nomePlanilha: document.getElementById('planNome').value,
        tamanhoArquivo: parseFloat(document.getElementById('planTamanho').value),
        qtdLinhas: parseFloat(document.getElementById('planLinhas').value),
        qtdColunas: parseFloat(document.getElementById('planColunas').value),
        usuarioCadastrado: { 
            id: document.getElementById('planUsuarioId').value 
        },
        status: document.getElementById('planStatus').value === "true"
    };

    fetch("http://localhost:8082/Cadastro de Planilha", { // <-- Ajuste para a rota correta do seu controller
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(payload)
    }).then(res => res.ok ? msg.innerText = "Sucesso!" : msg.innerText = "Erro ao salvar.").catch(() => msg.innerText = "Erro de conexão.");
});

// ==========================================
// CADASTRAR SCORE
// ==========================================
document.getElementById('formCadastrarScore').addEventListener('submit', function(event) {
    event.preventDefault();
    const msg = document.getElementById('msgCadScore');

    const payload = {
        descricao: document.getElementById('scoreDesc').value,
        score: document.getElementById('scoreValor').value
    };

    fetch("http://localhost:8082/Cadastro de Scores", { // <-- Ajuste a rota
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(payload)
    }).then(res => res.ok ? msg.innerText = "Sucesso!" : msg.innerText = "Erro ao salvar.").catch(() => msg.innerText = "Erro de conexão.");
});

// ==========================================
// CADASTRAR COMPARAÇÃO
// ==========================================
document.getElementById('formCadastrarComparacao').addEventListener('submit', function(event) {
    event.preventDefault();
    const msg = document.getElementById('msgCadComparacao');

    const payload = {
        planilhaInicial: { id: document.getElementById('compPlanInicialId').value },
        planilhaComparacao: { id: document.getElementById('compPlanComparacaoId').value },
        descricao: document.getElementById('compDescricao').value,
        status: true,
        scoreComparacao: { id: document.getElementById('compScoreId').value },
        data: document.getElementById('compData').value // Formato "YYYY-MM-DD" que o input type="date" já entrega
    };

    fetch("http://localhost:8082/Cadastro de Comparações", { // <-- Ajuste a rota
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(payload)
    }).then(res => res.ok ? msg.innerText = "Sucesso!" : msg.innerText = "Erro ao salvar.").catch(() => msg.innerText = "Erro de conexão.");
});

// ==========================================
// CADASTRAR HISTÓRICO
// ==========================================
document.getElementById('formCadastrarHistorico').addEventListener('submit', function(event) {
    event.preventDefault();
    const msg = document.getElementById('msgCadHistorico');
    
    // Pegando o ID da comparação que você quer salvar no histórico
    const idComp = document.getElementById('histComparacaoId').value;

    const payload = {
        comparacaoPlanilha: { id: idComp },
        data: { id: idComp } // Aqui repetimos o ID porque na sua classe Java, "data" é uma ComparacaoPlanilha.
    };

    fetch("http://localhost:8082/Cadastro de históricos de comparação", { // <-- Ajuste a rota
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(payload)
    }).then(res => res.ok ? msg.innerText = "Sucesso!" : msg.innerText = "Erro ao salvar.").catch(() => msg.innerText = "Erro de conexão.");
});