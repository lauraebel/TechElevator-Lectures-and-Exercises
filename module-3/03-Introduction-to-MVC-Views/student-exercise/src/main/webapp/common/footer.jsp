<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<hr />
        <footer>
        	<jsp:useBean id="now" class="java.util.Date" />
            <p>&copy; <fmt:formatDate value="${now}" pattern="yyyy" /> - Tech Elevator</p>
        </footer>
    </div>

</body>
</html>