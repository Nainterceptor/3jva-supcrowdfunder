<%--
  Created by IntelliJ IDEA.
  User: Fireaxe
  Date: 22/11/13
  Time: 02:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/includes/header.jsp"%>
<div class="container" style="width: 50%">
    <h2 class="form">Création d'un nouveau projet </h2>

    <form class="form-horizontal" action="/addProject">
        </br>
        <div class="form-group">
            <label for="nomProjet" class="col-sm-3 control-label">Nom du Projet</label>
            <div class="col-sm-9">
                <input type="text" class="form-control" id="nomProjet" placeholder="Nom du projet">
            </div>

        </div>
        <div class=form-group>
            <label for="createur">Créateur</label>
            <input class="form-control" id="createur" type="text" placeholder="NomDuCréateur" disabled>
        </div>
        <div class=form-group>
            <label for="categorie">Choisissez une catégorie de projet</label>
            <select class="form-control" id="categorie">
                <option>Catégorie 1</option>
                <option>Catégorie 2</option>
                <option>Catégorie 3</option>
            </select>
        </div>
        <div class=form-group>
            <label for="date">Date de fin des récoltes de fond</label>
            <input type="date" class="form-control" id="date">
        </div>
        <div class=form-group>
            <label for="description">Description complète du projet</label>
            <textarea class="form-control" id="description" rows="5"></textarea>
        </div>
        <button class="btn btn-lg btn-primary" type="submit">Envoyé</button>
    </form>
</div>
<%@ include file="/WEB-INF/includes/footer.jsp"%>
